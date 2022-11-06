package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class User {
    private static List<Integer> numbers;

    public void inputNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        if (verifyInput(input)) {
            duplicateCheck(input);
        }
        throw new IllegalArgumentException("숫자는 1부터 9까지로 이루어져야 합니다.");
    }

    public boolean verifyInput(String input) {
        return Pattern.matches("^[1-9]*$", input);
    }

    public List<Integer> duplicateCheck(String input) {
        numbers = Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        if (numbers.size() != 3) {
            throw new IllegalArgumentException("서로 다른 수로 이루어진 3자리의 수를 입력해야 합니다.");
        }
        return numbers;
    }
}
