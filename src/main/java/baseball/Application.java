package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    private static List<Integer> getThreeRandomNumber() {
        List<Integer> randomNumbers = new ArrayList<>();

        while (randomNumbers.size() < 3) {
            int tmpRandomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(tmpRandomNumber)) {
                randomNumbers.add(tmpRandomNumber);
            }
        }
        return randomNumbers;
    }

    private static List<Integer> disposeOfInputNumber() {
        String input = Console.readLine();
        if (!isValidBaseballNumber(input)) {
            throw new IllegalArgumentException();
        }

        List<Integer> inputNumbers = new ArrayList<>();

        for (char number : input.toCharArray()) {
            inputNumbers.add(number - '0');
        }

        return inputNumbers;
    }
    private static boolean isValidBaseballNumber(String input) {
        if (input.length() != 3) {
            return false;
        }

        List<Character> numberList = new ArrayList<>();
        for (char number : input.toCharArray()) {
            if (number > '9' || number < '0') {
                return false;
            }
            if (numberList.contains(number)) return false;

            numberList.add(number);
        }

        return true;
    }
}
