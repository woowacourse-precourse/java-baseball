package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    static int scanStartNumber() {
        String input = Console.readLine();
        if (isValidNumber(input)) {
            return Integer.parseInt(input);
        }
        return -1;
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

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            int startNumber = scanStartNumber();
        } catch (IllegalArgumentException e) {
            System.err.println(e);
        }
    }
}