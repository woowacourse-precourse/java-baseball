package baseball;


import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Input {
    private static final int NUMBER_SIZE = 3;
    private static final String RESTART = "1";
    private static final String EXIT = "2";
    private static final String ERROR_MESSAGE = "잘못된 값을 입력했습니다. 게임을 종료합니다.";
    private static final Character MIN_NUMBER = '1';
    private static final Character MAX_NUMBER = '9';

    public String inputUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInputNumber = Console.readLine();

        return userInputNumber;
    }

    public boolean isNumberSizeThree(String userNumber) {
        return userNumber.length() == NUMBER_SIZE;
    }

    public boolean isNumberDifferent(String userNumber) {
        Set<Character> numbers = new HashSet<>();

        for(char number : userNumber.toCharArray()) {
            numbers.add(number);
        }

        return userNumber.length() == numbers.size();
    }

    public boolean isNumberRangeValid(String userNumber) {
        for(int index = 0; index < userNumber.length(); index++) {
            if(userNumber.charAt(index) < MIN_NUMBER || userNumber.charAt(index) > MAX_NUMBER) {
                return false;
            }
        }
        return true;
    }

    public boolean isNumber(String userNumber) {
        for(int index = 0; index < userNumber.length(); index++) {
            char number = userNumber.charAt(index);
            if(!Character.isDigit(number)) {
                return false;
            }
        }
        return true;
    }

    public void inputUserNumberValid(String userNumber) {
        if(isNumberSizeThree(userNumber) && isNumberDifferent(userNumber)) {

            if(isNumberRangeValid(userNumber) && isNumber(userNumber)) {
                return;
            }
        }
        throw new IllegalArgumentException(ERROR_MESSAGE);
    }

    public String inputNumberGameRestartOrExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputNumber = Console.readLine();

        return inputNumber;
    }

    public void inputRestartOrExitNumberValid(String inputNumber) {
        if(!inputNumber.equals(RESTART) && !inputNumber.equals(EXIT)) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    public List<Integer> inputToList(String userNumber) {
        List<Integer> inputUserNumbers = new ArrayList<>();

        for(int index = 0; index < NUMBER_SIZE; index++) {
            char number = userNumber.charAt(index);
            inputUserNumbers.add(Character.getNumericValue(number));
        }

        return inputUserNumbers;
    }
}
