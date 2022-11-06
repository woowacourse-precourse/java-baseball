package baseball;

import java.util.HashMap;
import java.util.Scanner;

public class Player {
    private static final int DESIRED_LENGTH = 3;

    Scanner sc = Application.sc;

    public int guessRandomNumber() {
        String input = sc.nextLine();

        if (!isValidInput(input)) {
            throw new IllegalArgumentException("잘못된 형식의 값을 입력했습니다.");
        }

        return Integer.parseInt(input);
    }

    public boolean isValidInput(String input) {
        return containOnlyDigit(input) && isCorrectLength(input) && !containZero(input) && !hasDuplicatedDigit(input);
    }

    public boolean containOnlyDigit(String input) {
        for (Character character : input.toCharArray()) {
            if (!Character.isDigit(character)) {
                return false;
            }
        }
        return true;
    }

    public boolean isCorrectLength(String input) {
        return input.length() == DESIRED_LENGTH;
    }

    public boolean containZero(String input) {
        return input.contains("0");
    }

    public boolean hasDuplicatedDigit(String input) {
        HashMap<Character, Integer> numberOfCharacter = new HashMap<>();
        for (Character character : input.toCharArray()) {
            numberOfCharacter.put(character, numberOfCharacter.getOrDefault(character, 0) + 1);
        }
        for (int number : numberOfCharacter.values()) {
            if (number > 1) {
                return true;
            }
        }
        return false;
    }
}
