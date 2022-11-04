package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class User {

    private static final String RECEIVE_THREE_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";

    private final List<Integer> inputNumber = new ArrayList<>();

    public User() {
    }

    public void receiveThreeNumber() {
        System.out.print(RECEIVE_THREE_NUMBER_MESSAGE);
        String input = Console.readLine();
        if (!isValidateThreeNumber(input)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isValidateThreeNumber(String input) {
        return (isValidateLength(input) && isNumber(input) && isDifferentNumber(input));
    }

    private boolean isValidateLength(String input) {
        return input.length() == 3;
    }

    private boolean isNumber(String input) {
        for (char ch : input.toCharArray()) {
            if (ch < '1' || ch > '9') {
                return false;
            }
        }
        return true;
    }

    private boolean isDifferentNumber(String input) {
        char number1 = input.charAt(0);
        char number2 = input.charAt(1);
        char number3 = input.charAt(2);

        return (number1 != number2 && number2 != number3 && number3 != number1);
    }

}
