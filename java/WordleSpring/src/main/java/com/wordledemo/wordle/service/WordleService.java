package com.wordledemo.wordle.service;

import com.wordledemo.wordle.db.*;
import com.wordledemo.wordle.webservices.CharacterResult;
import com.wordledemo.wordle.webservices.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Service
@RequiredArgsConstructor
@Transactional
public class WordleService {
    private static final String WORD = "LYMPH";
    private static final List<String> DICTIONARY = new ArrayList<>();

    private final UserRepository userRepository;
    private final GameRepository gameRepository;

    static {
        try(InputStream is = new ClassPathResource("words.txt").getInputStream()) {
            Scanner scanner = new Scanner(is).useDelimiter("\n");
            while(scanner.hasNext()) {
                DICTIONARY.add(scanner.next().toUpperCase());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String validate(String word) {
        if (word.length() != 5) {
            return  "Bad length";
        }

        word = word.toUpperCase();

        if (!DICTIONARY.contains(word)) {
            return "Not a word";
        }
        return null;
    }

    public CharacterResult[] calculateResults(String userId, String word) {
        word = word.toUpperCase();

        WebUser webUser = userRepository.findByUuid(userId)
                .orElseGet(() -> new WebUser(userId));

        Game game = new Game();
        game.setWord(WordleService.WORD);
        game.setGuess(word);
        if (webUser.getId() != null) {
            game.setAttempt((int) gameRepository.countByWordAndWebUser(WORD, webUser));
        }

        webUser.addGame(game);
        userRepository.save(webUser);
        gameRepository.save(game);

        CharacterResult[] results = new CharacterResult[WORD.length()];
        for (int iter = 0; iter < word.length(); iter++) {
            char currentChar = word.charAt(iter);
            if (currentChar == WORD.charAt(iter)) {
                results[iter] = CharacterResult.GREEN;
                continue;
            }
            if (WORD.indexOf(currentChar) > -1) {
                results[iter] = CharacterResult.YELLOW;
            }
            results[iter] = CharacterResult.BLACK;
        }

        return results;
    }

    public Map<String, Integer> getAttemptsPerWord(String userId)
    {
        Optional<WebUser> webUser = userRepository.findByUuid(userId);

        if (webUser.isPresent()) {
            Map<String, Integer> response = new HashMap<>();
            for (Game g : webUser.get().getGames()) {
                Integer count = response.getOrDefault(g.getWord(), 0);
                response.put(g.getWord(), count + 1);
            }
            return response;
        }
        return Collections.emptyMap();
    }
}
