import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final String WORD = "LYMPH";
    private static List<String> DICTIONARY;
    private static List<String> words;

    public static void main(String[] args) throws IOException {
        File statusFile = new File("state.txt");
        List<String> status;
        if (statusFile.exists()) {
            status = Files.readAllLines(statusFile.toPath());
        } else {
            status = Collections.emptyList();
        }

        DICTIONARY = Files.readAllLines(new File("words.txt").toPath());
        DICTIONARY = DICTIONARY.stream().map(String::toUpperCase).toList();

        System.out.println("Write a guess");
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;

        for (String line = scanner.nextLine(); line != null; line = scanner.nextLine()) {
            if (line.length() != 5) {
                System.out.println("Must enter 5 char");
                continue;
            }
            line = line.toUpperCase();

            if (line.equals(WORD)) {
                System.out.println("Success");
                words.add(line);
                finishGame();
            }
            if (!DICTIONARY.contains(line)) {
                System.out.println("That is not a valid guess");
            } else {
                words.add(line);
                attempts++;
                printWordResult(line);
                if (attempts > 7) {
                    System.out.println("Game over");
                    finishGame();
                }
            }
        }
    }

    private static void finishGame() throws IOException {
        try (Writer writer = new FileWriter("state.txt", true)) {
            writer.write(System.currentTimeMillis() + ","
                    + WORD + ","
                    String.join(",", words) + "\n");

        }
        System.exit(0);
    }

    private static void printWordResult(String word) {
        for (int iter = 0; iter < word.length(); iter++) {
            char currentChar = word.charAt(iter);
            if (currentChar == WORD.charAt(iter)) {
                System.out.print("G"); // Green
                continue;
            }
            if (WORD.indexOf(currentChar) > -1) {
                System.out.print("Y"); // Yellow
                continue;
            }
            System.out.print("B"); // Black
        }
        System.out.println();
    }
}