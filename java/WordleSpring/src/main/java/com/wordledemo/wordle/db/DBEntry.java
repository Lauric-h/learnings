package com.wordledemo.wordle.db;

public record DBEntry(String user, String guess, String word, int attempt) {
}
