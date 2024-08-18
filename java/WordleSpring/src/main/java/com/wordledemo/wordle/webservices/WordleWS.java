package com.wordledemo.wordle.webservices;

import com.wordledemo.wordle.service.WordleService;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@RestController
@AllArgsConstructor
public class WordleWS {
    private final WordleService wordleService;

    @GetMapping("/guess")
    public Result guess(@CookieValue(required = false) String userId, String word) {
        var error = wordleService.validate(word);
        if (null != error) {
            return new Result(null, error);
        }

        return new Result(wordleService.calculateResults(userId, word), null);
    }
}
