package baseball;

import java.util.List;
import java.util.Scanner;

public class BaseballGameInputFilter {

    private final Scanner scanner = new Scanner(System.in);

    private int numberLength = 3;

    public boolean isValidLength(String input) {
        return input.length() == this.numberLength;
    }

    public boolean isNumeric(String input) {
        return input.matches("[1-9]+");
    }

    public boolean isNotDuplicated(String input) {
        return input.length() == List.of(input.split(""))
                .stream()
                .distinct()
                .count();
    }

    public String readNumbers(){
        String input = scanner.nextLine();

        if (!this.isValidLength(input)) {
            throw new IllegalArgumentException();
        }
        if (!this.isNumeric(input)) {
            throw new IllegalArgumentException();
        }
        if (!this.isNotDuplicated(input)) {
            throw new IllegalArgumentException();
        }

        return input;
    }

}
