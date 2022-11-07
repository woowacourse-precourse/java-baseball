package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class User {
    private static List<Integer> numbers;

    public void inputNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        validateInput(input);
        numbers = getNumbers(input);
        validateDuplicate(numbers);
    }

    private void validateInput (String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("입력한 수가 3자리가 아닙니다.");
        }
        if (!input.matches("^[1-9]*$")) {
            throw new IllegalArgumentException("입력한 수가 1-9가 아닙니다.");
        }
    }

    public List<Integer> getNumbers(String input) {
        return numbers = Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .distinct()
                .collect(Collectors.toList());
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> duplicateCheck = new HashSet<>(numbers);
        if (duplicateCheck.size() != 3) {
            throw new IllegalArgumentException("서로 다른 수로 이루어진 3자리의 수를 입력해야 합니다.");
        }
    }
}
