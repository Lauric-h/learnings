package com.wordledemo.wordle.web;

import com.wordledemo.wordle.service.WordleService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class WebController {
    private final WordleService wordleService;

    private static List<String> attempts = new ArrayList<>();

    @GetMapping("/guessMVC")
    private String guess(
            HttpServletResponse response,
            @CookieValue(required = false) String userId,
            Model model
    ) {
        userId = this.initUserId(response, userId);
        this.showAttempts(userId, model);

        return "Wordleguess";
    }

    private String initUserId(HttpServletResponse response, String userId)
    {
        if (userId == null) {
            userId = UUID.randomUUID().toString();
            Cookie cookie = new Cookie("userId", userId);
            cookie.setMaxAge(3650 * 24 * 60 * 60);
            response.addCookie(cookie);
        }
        return userId;
    }

    @PostMapping("/guessMVC")
    private String submitGuess(
            HttpServletResponse response,
            @CookieValue(required = false) String userId,
            String guess, Model model
    ) {
        String error = wordleService.validate(guess);
        if (error != null) {
            model.addAttribute("errorMessage", error);
        } else {
            model.addAttribute("errorMessage", "");
            attempts.add(guess);
        }

        this.showAttempts(userId,   model);

        return "Wordleguess";
    }

    private void showAttempts(String userId, Model model) {
        List<WebResult[]> results = attempts.stream()
                .map(str -> WebResult.create(wordleService.calculateResults(userId, str), str))
                .toList();

        model.addAttribute("entries", results);
    }
}
