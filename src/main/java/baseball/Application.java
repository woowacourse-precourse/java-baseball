package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    final static int DIGIT_1 = 0;
    final static int DIGIT_10 = 1;
    final static int DIGIT_100 = 2;

    final static int STRIKE = 0;
    final static int BALL = 1;
    final static int NOTHING = 2;

    public static List<Integer> computerDigitValue;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static List<Integer> compareUserInputAndComputerSelect(int userInput){
        List<Integer> point = new ArrayList<>(Arrays.asList(0, 0, 0));
        List<Integer> disassembledNumber = disassembleDigitNumber(userInput);
        for(int digit = DIGIT_1; digit <= DIGIT_100; digit++) {
            int number = disassembledNumber.get(digit);
            int result = getScore(number, digit);
            int p = point.get(result) + 1;
            point.set(result, p);
        }

        return point;
    }

    public static int getScore(int number, int DIGIT){
        if(computerDigitValue.get(DIGIT) == number) {
            return STRIKE;
        }
        if(computerDigitValue.contains(number)) {
            return BALL;
        }else{
            return NOTHING;
        }
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
