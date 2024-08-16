package com.wordledemo.wordle.web;

import com.wordledemo.wordle.service.WordleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class WebController {
    private final WordleService wordleService;

    private static List<String> attempts = new ArrayList<>();

    @GetMapping("/guessMVC")
    private String guess(Model model) {
        this.showAttempts(model);

        return "Wordleguess";
    }

    @PostMapping("/guessMVC")
    private String submitGuess(String guess, Model model) {
        String error = wordleService.validate(guess);
        if (error != null) {
            model.addAttribute("errorMessage", error);
        } else {
            model.addAttribute("errorMessage", "");
            attempts.add(guess);
        }

        this.showAttempts(model);

        return "Wordleguess";
    }

    private void showAttempts(Model model) {
        List<WebResult[]> results = attempts.stream()
                .map(str -> WebResult.create(wordleService.calculateResults(str), str))
                .toList();

        model.addAttribute("entries", results);
    }
}
