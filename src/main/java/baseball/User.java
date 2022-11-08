package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {
    public List<Integer> ThreeDifferentNumber;

    public List<Integer> getThreeDifferentNumber() {
        String userInput = inputThreeNumber();
        List<Integer> numberList;

        handleException(userInput);
        numberList = makeListThreeNumber(userInput);

        return numberList;
    }

    private String inputThreeNumber() {
        System.out.println("숫자를 입력해 주세요 : ");

        String userInput = Console.readLine();

        return userInput;
    }

    private void handleException(String userInput) {
        checkThreeLengthNumber(userInput);
        checkOneToNineRangeNumber(userInput);
        checkThreeDifferentNumber(userInput);
    }

    private void checkThreeLengthNumber(String userInput) {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException("입력이 세자리 수여야 합니다.")
        }
    }

    private void checkOneToNineRangeNumber(String userInput) {
        for (int i = 0; i < 3; i++) {
            char number = userInput.charAt(i);
            if (number < '1' || number > '9') {
                throw new IllegalArgumentException("1~9 범위의 숫자만 입력해야 합니다.")
            }
        }
    }

    private void checkThreeDifferentNumber(String userInput) {
        Set<Character> numberSet = new HashSet<>();

        for (int i = 0; i < 3; i++) {
            Character number = userInput.charAt('i');
            numberSet.add(number);
        }

        if (numberSet.size() != 3) {
            throw new IllegalArgumentException("서로 다른 세 수를 입력해야 합니다.")
        }
    }

    private List<Integer> makeListThreeNumber(String userInput) {
        List<Integer> threeNumber = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int number = userInput.charAt(i) - '0';
            threeNumber.add(number);
        }

        return threeNumber;
    }



}
