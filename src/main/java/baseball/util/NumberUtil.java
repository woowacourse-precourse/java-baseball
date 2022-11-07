package baseball.util;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.view.BaseBallView.*;

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

    public static boolean isCorrect(List<Integer> answerNumber, List<Integer> userNumber) {
        List<Integer> hintList = judgeHint(answerNumber, userNumber);

        printHintByList(hintList);

        return isThreeStrike(hintList);
    }

    public static List<Integer> judgeHint(List<Integer> answerNumber, List<Integer> userNumber) {
        List<Integer> hintList = new ArrayList<>();
        for (int index = 0; index < 2; index++) {
            hintList.add(0);
        }

        for (int index = 0; index < answerNumber.size(); index++) {
            if (userNumber.get(index).equals(answerNumber.get(index))) {
                hintList.set(1, (hintList.get(1).intValue() + 1));
            } else if (userNumber.contains(answerNumber.get(index))) {
                hintList.set(0, (hintList.get(0).intValue() + 1));
            }
        }

        return hintList;
    }

    public static void printHintByList(List<Integer> hintList) {
        if (hintList.get(0) != 0) {
            printBall(hintList.get(0).intValue());
        }
        if (hintList.get(1) != 0) {
            printStrike(hintList.get(1).intValue());
        }
        if ((hintList.get(0) == 0) && hintList.get(1) == 0) {
            printNothing();
        }
        System.out.println();
    }

    public static boolean isThreeStrike(List<Integer> hintList) {
        if (hintList.get(1) == 3) {
            printGiveCorrectAnswer();
            printInputNewGame();
            return true;
        }

        return false;
    }

    public static boolean isRestart() {
        String inputString = Console.readLine();
        int inputNumber = toInteger(inputString);

        if (inputNumber == 1) {
            return true;
        }
        if (inputNumber == 2) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static int toInteger(String inputString) {
        try {
            return Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}