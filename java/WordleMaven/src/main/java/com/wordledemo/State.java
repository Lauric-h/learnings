package com.wordledemo;

import java.util.List;

public record State(String word, long time, List<String> attempts) {
}
