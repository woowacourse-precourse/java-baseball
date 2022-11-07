package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static final int INPUT_SIZE = 3;
    private String user_input_string = "";
    public void userInput() {
        System.out.print("숫자를 입력해주세요 : ");
        user_input_string = Console.readLine();
        checkInput(user_input_string);
    }
    public List<Integer> getUserInput() {
        List<Integer> input = new ArrayList<>();
        for (int i = 0; i < INPUT_SIZE; i++) {
            input.add(Character.getNumericValue(user_input_string.charAt(i)));
        }
        return input;
    }
    public int userReGameInput() {
        String input = Console.readLine();
        if (Integer.parseInt(input) == 1) {
            return 1;
        } else if (Integer.parseInt(input) == 2) {
            return 2;
        } else {
            throw new IllegalArgumentException();
        }
    }
    private void checkInput(String input) {
        if (!checkInputLength(input)) {
            throw new IllegalArgumentException("잘못된 길이입니다.");
        } else if (!checkInputDigit(input)) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }
    private boolean checkInputLength(String input) {
        return input.length() == INPUT_SIZE;
    }
    private boolean checkInputDigit(String input) {
        return input.chars().allMatch(Character::isDigit);
    }
}
