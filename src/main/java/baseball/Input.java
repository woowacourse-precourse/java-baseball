package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {
    private static final int SIZE = 3;

    public static List<Integer> generateNumbers() {

        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() != SIZE) {
            int number = Randoms.pickNumberInRange(1, 9);

            if (!randomNumbers.contains(number))
                randomNumbers.add(number);
        }

        return randomNumbers;
    }

    public static List<Integer> getInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        validateInput(input);

        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void validateInput(String input) throws IllegalArgumentException {
        if (!input.trim().matches("[0-9]+")) {
            throw new IllegalArgumentException();
        }
        if (input.trim().length() != 3)
            throw new IllegalArgumentException();
    }
}
