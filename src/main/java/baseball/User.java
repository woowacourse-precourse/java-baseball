package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {
    private String number;
    private static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_NUMBER = "숫자를 입력해주세요 : ";

    public void inputNumber() {
        System.out.print(INPUT_NUMBER);
        number = Console.readLine();
    }

    public void printGameStart() {
        System.out.println(GAME_START);
    }

    public List<Integer> createUserNumber() {
        inputNumber();
        String[] splitNumbers = number.split("");
        List<Integer> userNumbers = new ArrayList<>();
        for (String number : splitNumbers) {
            int numberToInt = Integer.parseInt(number);
            userNumbers.add(numberToInt);
        }
        inputException(userNumbers);
        return userNumbers;
    }

    public void inputException(List<Integer> userNumbers) {
        if (!isDeduplication(userNumbers)) {
            throw new IllegalArgumentException();
        }
        int userNumbersSize = userNumbers.size();
        if (userNumbersSize != 3) {
            throw new IllegalArgumentException();
        }
        if (!isNumber(userNumbers)) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isDeduplication(List<Integer> userNumbers) {
        for (int number : userNumbers) {
            int numberFrequency = Collections.frequency(userNumbers, number);
            if (numberFrequency > 1) {
                return false;
            }
        }
        return true;
    }

    public boolean isNumber(List<Integer> userNumbers) {
        for (int number : userNumbers) {
            if (number < 1 || number > 9) {
                return false;
            }
        }
        return true;
    }

    public int inputRestartNumber() {
        number = Console.readLine();
        int inputNumber = Integer.parseInt(number);
        return inputNumber;
    }
}