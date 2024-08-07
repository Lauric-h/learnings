import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final String WORD = "LYMPH";
    private static final String[] DICTIONARY = {"CRATE", "USING", "LYMPH", "LUMPS"};

    public static void main(String[] args) {
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
                return;
            }
            if (!isInDictionary(line)) {
                System.out.println("That is not a valid guess");
            } else {
                attempts++;
                printWordResult(line);
                if (attempts > 7) {
                    System.out.println("Game over");
                    return;
                }
            }
        }
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

    private static boolean isInDictionary(String word) {
        for (String current : DICTIONARY) {
            if (current.equals(word)) {
                return true;
            }
        }
        return false;
    }
}