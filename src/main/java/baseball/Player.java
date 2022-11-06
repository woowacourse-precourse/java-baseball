package baseball;

import java.util.HashMap;
import java.util.Scanner;

public class Player {
    private static final int DESIRED_LENGTH = 3;
    private static final int NUM_OF_SELECTABLE_MENU = 2;

    Scanner sc = Application.sc;

    public int guessRandomNumber() {
        String input = sc.nextLine();
        validateGuess(input);
        return Integer.parseInt(input);
    }

    public int selectExitMenu() {
        String input = sc.nextLine();
        validateMenuSelection(input);
        return Integer.parseInt(input);
    }


    public void validateGuess(String input) {
        if (!containOnlyDigit(input)) {
            throw new IllegalArgumentException("숫자 이외의 값을 입력했습니다.");
        }
        if (!isCorrectLength(input)) {
            throw new IllegalArgumentException("잘못된 길이의 값을 입력했습니다.");
        }
        if (containZero(input)) {
            throw new IllegalArgumentException("0은 입력할 수 없습니다.");
        }
        if (hasDuplicatedDigit(input)) {
            throw new IllegalArgumentException("하나의 숫자가 두 번 이상 입력되었습니다.");
        }
    }

    public void validateMenuSelection(String input) {
        if (!containOnlyDigit(input)) {
            throw new IllegalArgumentException("숫자 이외의 값을 입력했습니다.");
        }
        if (!isExistingMenu(input)) {
            throw new IllegalArgumentException("존재하지 않는 메뉴를 선택했습니다.");
        }
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

    public boolean isExistingMenu(String input) {
        int menuSelection = Integer.parseInt(input);

        return menuSelection >= 1 && menuSelection <= NUM_OF_SELECTABLE_MENU;
    }
}
