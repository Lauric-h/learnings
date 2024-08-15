package com.wordledemo.wordle.webservices;

public record Result(CharacterResult[] results, String errorMessage) {
}
