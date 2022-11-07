package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static final int INPUT_SIZE = 3;
    private String user_input_string = "";
    public void userInput() {
        System.out.println("숫자를 입력해주세요 : ");
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
    private void checkInput(String input) {
        if (!checkInputLength(input)) {
            throw new IllegalArgumentException();
        } else if (!checkInputDigit(input)) {
            throw new IllegalArgumentException();
        }
    }
    private boolean checkInputLength(String input) {
        return input.length() == INPUT_SIZE;
    }
    private boolean checkInputDigit(String input) {
        return input.chars().allMatch(Character::isDigit);
    }
}
