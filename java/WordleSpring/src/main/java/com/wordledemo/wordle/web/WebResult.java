package com.wordledemo.wordle.web;

import com.wordledemo.wordle.webservices.CharacterResult;

public record WebResult(CharacterResult color, char letter) {
    public static WebResult[] create(CharacterResult[] colors, String text) {
        WebResult[] results = new WebResult[colors.length];
        for (int i = 0; i < colors.length; i++) {
            results[i] = new WebResult(colors[i], text.charAt(i));
        }
        return results;
    }

}
