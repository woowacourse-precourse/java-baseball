package baseball;

import java.util.List;
import java.util.Scanner;

public class BaseballGameInputFilter {

    private final Scanner scanner = new Scanner(System.in);

    private int numberLength = 3;

    public boolean isValidLength(String input) {
        return input.length() == this.numberLength;
    }

}