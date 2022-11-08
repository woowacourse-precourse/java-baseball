package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Number {
    private static final int NUM_LENGTH = 3;

    public static int readNum() {
        printGuideMessage();

        int inputNum;
        try {
            inputNum = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        validateNum(inputNum);

        return inputNum;
    }

    public static int generateRandomNumber() {
        List<Integer> numList = new ArrayList<>();

        while (numList.size() != NUM_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numList.contains(randomNumber)) {
                numList.add(randomNumber);
            }
        }

        int opponentNumber = numListToThreeDigits(numList);

        validateNum(opponentNumber);

        return opponentNumber;
    }

    public static List<Integer> threeDigitsToNumList(int number) {
        List<Integer> eachDigits = new ArrayList<>();

        int denominator = 100;
        for (int index = 0; index < NUM_LENGTH; index++) {
            eachDigits.add(number / denominator);

            number %= denominator;
            denominator /= 10;
        }
        return eachDigits;
    }

    public static int numListToThreeDigits(List<Integer> eachDigits) {
        int threeDigits = 0;
        for (int index = 0; index < NUM_LENGTH - 1; index++) {
            threeDigits += eachDigits.get(index);
            threeDigits *= 10;
        }
        threeDigits += eachDigits.get(2);

        return threeDigits;
    }

    private static void validateNum(int number) {
        validateNumLength(number);
        validateOneToNine(number);
        validateNotDuplicate(number);
    }

    private static void validateNumLength(int number) {
        int length = (int) (Math.log10(number) + 1);
        if (length != NUM_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateOneToNine(int number) {
        List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        while (number != 0) {
            int digit = number % 10;
            if (!numList.contains(digit)) {
                throw new IllegalArgumentException();
            }
            number /= 10;
        }
    }

    private static void validateNotDuplicate(int number) {
        List<Integer> numList = new ArrayList<>();

        while (number != 0) {
            int digit = number % 10;
            if (numList.contains(digit)) {
                throw new IllegalArgumentException();
            }
            numList.add(digit);
            number /= 10;
        }
    }

    private static void printGuideMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }
}
