package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    final static int DIGIT_1 = 0;
    final static int DIGIT_10 = 1;
    final static int DIGIT_100 = 2;

    public static List<Integer> computerDigitValue;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static boolean isValidData(int userInput) {
        List<Integer> disassembledNumber = disassembleDigitNumber(userInput);
        if (disassembledNumber.size() != 3) {
            return false;
        }

        List<Integer> duplicatedList = new ArrayList<>();
        for (int number : disassembledNumber) {
            if (duplicatedList.contains(number)) {
                return false;
            }
            duplicatedList.add(number);
        }

        return true;
    }

    public static List<Integer> toPlaceValue(List<Integer> disassembledNumber) {
        List<Integer> placeValue = new ArrayList<Integer>();
        int digit = 1;
        for (int number : disassembledNumber) {
            placeValue.add(number * digit);
            digit *= 10;
        }

        return placeValue;
    }

    public static List<Integer> disassembleDigitNumber(int number) {
        List<Integer> disassembledNumber = new ArrayList<Integer>();
        for (; number > 0; number /= 10) {
            disassembledNumber.add(number % 10);
        }

        return disassembledNumber;
    }

    public static int getRandomThreeDigitNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        int randomValue = 0;
        for (int i = 0, digit = 1; digit <= 100; i++, digit *= 10) {
            randomValue += computer.get(i) * digit;
        }
        return randomValue;
    }
}
