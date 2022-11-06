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
            int divisor = 100;
            for (int i = 0; i < 3; i++) {
                int digit = inputNumber / divisor;
                userNumber.add(digit);
                inputNumber %= divisor;
                divisor /= 10;
            }
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
        List<Integer> digits = new ArrayList<>();
        int divisor = 100;
        for (int i = 0; i < 3; i++) {
            int digit = (int) (inputNumber / divisor);
            if (digit == 0 || digits.contains(digit)) {
                throw new IllegalArgumentException();
            }
            digits.add(digit);
            inputNumber %= divisor;
            divisor /= 10;
        }
        return true;
    }

    static void registerComputerNumber() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        computerNumber = randomNumbers;
    }

    public static void main(String[] args) {
        try {
            registerUserNumber();
            System.out.println(userNumber);
            registerComputerNumber();
            System.out.println(computerNumber);
        } catch (IllegalArgumentException e) {
            System.err.println(e);
        }
    }
}