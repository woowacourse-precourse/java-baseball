package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    static private List<Integer> userNumber = new ArrayList<>();
    static private List<Integer> computerNumber = new ArrayList<>();

    static void registerUserNumber() {
        String input = Console.readLine();
        if (isValidNumber(input)) {
            int inputNumber = Integer.parseInt(input);
            userNumber = NumberToIntegerList(inputNumber);
        }
    }

    static boolean isValidNumber(String input) throws IllegalArgumentException {
        int inputNumber;
        try {
            inputNumber = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        if (99 > inputNumber || 999 < inputNumber) {
            throw new IllegalArgumentException();
        }
        List<Integer> inputNumberList = NumberToIntegerList(inputNumber);
        if (inputNumberList.contains(0)) {
            throw new IllegalArgumentException();
        }
        if (inputNumberList.size() != inputNumberList.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    static List<Integer> NumberToIntegerList(int number) {
        List<Integer> digits = new ArrayList<>();
        int divisor = 100;
        for (int i = 0; i < 3; i++) {
            int digit = number / divisor;
            digits.add(digit);
            number %= divisor;
            divisor /= 10;
        }
        return digits;
    }

    static void registerComputerNumber() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        computerNumber = randomNumbers;
    }

    static void judgeCount() {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            int currentUserNumber = userNumber.get(i);
            int currentComputerNumber = computerNumber.get(i);
            if (currentUserNumber == currentComputerNumber) {
                strike++;
                continue;
            }
            if (computerNumber.contains(currentUserNumber)) {
                ball++;
            }
        }
    }

    public static void main(String[] args) {
        try {
            registerUserNumber();
            System.out.println(userNumber);
            registerComputerNumber();
            System.out.println(computerNumber);
            judgeCount();
        } catch (IllegalArgumentException e) {
            System.err.println(e);
        }
    }
}