package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class User {

    private static final String RECEIVE_THREE_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String RECEIVE_ONE_NUMBER_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private final List<Integer> inputNumber = new ArrayList<>();

    public User() {
    }

    public void receiveThreeNumber() {
        System.out.print(RECEIVE_THREE_NUMBER_MESSAGE);
        String input = Console.readLine();
        if (!isValidateThreeNumber(input)) {
            throw new IllegalArgumentException();
        }
        setInputNumber(input);
    }

    public List<Integer> getThreeNumber() {
        return this.inputNumber;
    }

    public void resetUserNumber() {
        inputNumber.clear();
    }

    public void receiveOneNumber() {
        System.out.println(RECEIVE_ONE_NUMBER_MESSAGE);
        String input = Console.readLine();
        if (!isValidateOneNumber(input)) {
            throw new IllegalArgumentException();
        }
        setInputNumber(input);
    }

    private boolean isValidateOneNumber(String input) {
        return (isValidateLength(input, 1) && isOneOrTwo(input));
    }

    private boolean isValidateThreeNumber(String input) {
        return (isValidateLength(input, 3) && isNumber(input) && isDifferentNumber(input));
    }

    private boolean isValidateLength(String input, int size) {
        return input.length() == size;
    }

    private boolean isNumber(String input) {
        for (char ch : input.toCharArray()) {
            if (ch < '1' || ch > '9') {
                return false;
            }
        }
        return true;
    }

    private boolean isOneOrTwo(String input) {
        char ch = input.charAt(0);
        return (ch == '1' || ch == '2');
    }

    private boolean isDifferentNumber(String input) {
        char number1 = input.charAt(0);
        char number2 = input.charAt(1);
        char number3 = input.charAt(2);

        return (number1 != number2 && number2 != number3 && number3 != number1);
    }

    private void setInputNumber(String input) {
        int number = toInt(input);
        addEachOfDigit(number);
    }

    private void addEachOfDigit(int number) {
        if (number == 0) {
            return;
        }
        addEachOfDigit(number / 10);
        inputNumber.add(number % 10);
    }

    private int toInt(String input) {
        return Integer.parseInt(input);
    }
}
