package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class BaseballNumber {
    private ArrayList<Integer> numbers = new ArrayList<>();

    public void setNumbersByRandom() {
        numbers.clear();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }

    public void setNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String numbersStr = Console.readLine();

        if (!isError(numbersStr))
            throw new IllegalArgumentException();

        numbers.clear();
        for (int i = 0; i < 3; i++) {
            int number = Character.getNumericValue(numbersStr.charAt(i));
            numbers.add(number);
        }
    }

    public ArrayList<Integer> getNumbers() {
        return numbers;
    }

    public boolean is3Digit(String numbersStr) {
        if (numbersStr.length() == 3) {
            return true;
        }
        return false;
    }

    public boolean isAllInteger(String numbersStr) {
        for (int i = 0; i < numbersStr.length(); i++) {
            if ('0' > numbersStr.charAt(i) || numbersStr.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    public boolean isNonZero(String numbersStr) {
        for (int i = 0; i < numbersStr.length(); i++) {
            if (numbersStr.charAt(i) == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isNotRepeat(String numbersStr) {
        if (numbersStr.charAt(0) == numbersStr.charAt(1))
            return false;
        if (numbersStr.charAt(0) == numbersStr.charAt(2))
            return false;
        if (numbersStr.charAt(1) == numbersStr.charAt(2))
            return false;
        return true;
    }

    public boolean isError(String numbersStr) {
        if (!is3Digit(numbersStr))
            return false;
        if (!isAllInteger(numbersStr))
            return false;
        if (!isNonZero(numbersStr))
            return false;
        if (!isNotRepeat(numbersStr))
            return false;
        return true;
    }
}
