package baseball;

import java.util.List;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    private static List<Integer> generateThreeRandomNumber() {
        List<Integer> computerNumber = new ArrayList<>(3);

        for (int i = 0; i < 3; i++) {
            Integer num = Randoms.pickNumberInRange(1, 9);

            if (computerNumber.contains(num)) {
                i--;
                continue;
            }
            computerNumber.add(num);
        }

        return computerNumber;
    }

    private static List<Integer> parseInput(String input) {
        List<Integer> inputNumber = new ArrayList<>(3);

        if (input.length() != 3)
            throw new IllegalArgumentException();

        for (int i = 0;i < 3;i++) {
            char c = input.charAt(i);

            if (c < '1' || c > '9')
                throw new IllegalArgumentException();
            if (inputNumber.contains(c - '0'))
                throw new IllegalArgumentException();

            inputNumber.add(c - '0');
        }

        return inputNumber;
    }
}
