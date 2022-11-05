package baseball.util;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.view.Print.*;

public class NumberUtil {
    public static List<Integer> createRandomNumber() {
        List<Integer> answerList = new ArrayList<>();

        while (answerList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answerList.contains(randomNumber)) {
                answerList.add(randomNumber);
            }
        }

        return answerList;
    }

    public static List<Integer> getUserNumber() {
        List<Integer> answerList = new ArrayList<>();

        printInputNumber();

        String inputNumber = Console.readLine();
        checkInputException(inputNumber);
        answerList = stringToList(inputNumber);

        return answerList;
    }

    public static List<Integer> stringToList(String inputNumber) {
        List<Integer> answerList = new ArrayList<>();

        for (int index = 0; index < inputNumber.length(); index++) {
            answerList.add(Character.getNumericValue(inputNumber.charAt(index)));
        }

        return answerList;
    }

    public static void checkInputException(String inputNumber) {
        if (!isStringSize(inputNumber)) {
            throw new IllegalArgumentException();
        }
        if (!isStringRange(inputNumber)) {
            throw new IllegalArgumentException();
        }
        if (!isStringDuplicated(inputNumber)) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean isStringSize(String inputNumber) {
        if (inputNumber.length() == 3) {
            return true;
        }

        return false;
    }

    public static boolean isStringRange(String inputNumber) {
        for (int index = 0; index < inputNumber.length(); index++) {
            int indexNumber = (inputNumber.charAt(index) - '0');
            if (indexNumber < 10 && indexNumber > 0) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }

    public static boolean isStringDuplicated(String inputNumber) {
        List<Integer> numberList = stringToList(inputNumber);

        for (int index = 0; index < numberList.size(); index++) {
            int number = numberList.get(index);
            numberList.remove(index);
            if (numberList.contains(number)) {
                return false;
            }
        }

        return true;
    }
}
