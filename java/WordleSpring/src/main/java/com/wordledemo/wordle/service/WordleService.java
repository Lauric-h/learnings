package com.wordledemo.wordle.service;

import com.wordledemo.wordle.webservices.CharacterResult;
import com.wordledemo.wordle.webservices.Result;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class WordleService {
    private static final String WORD = "LYMPH";
    private static final List<String> DICTIONARY = new ArrayList<>();

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

    public CharacterResult[] calculateResults(String word) {
        word = word.toUpperCase();

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
}
