package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class User {
    private List<Integer> numbers;

    public User() {
        this.numbers = Collections.emptyList();
    }

    private String inputNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        return input;
    }

    public void setNumbers(String input) {
        validateInput(input);
        this.numbers = validateDuplicate(input);
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

    private void validateInput(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("입력한 수가 3자리가 아닙니다.");
        }
        if (!input.matches("^[1-9]*$")) {
            throw new IllegalArgumentException("입력한 수가 1-9가 아닙니다.");
        }
    }

    private List<Integer> validateDuplicate(String input) {
        List<Integer> numbers = Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .distinct()
                .collect(Collectors.toList());
        if (numbers.size() != 3) {
            throw new IllegalArgumentException("서로 다른 수로 이루어진 3자리의 수를 입력해야 합니다.");
        }
        return numbers;
    }
}
