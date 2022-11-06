package baseball.model;

import baseball.view.BaseballConsole;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {

    private List<Integer> numbers;
    private BaseballConsole baseballConsole;

    public User() {
        numbers = new ArrayList<>();
        baseballConsole = new BaseballConsole();
    }

    public void inputNumber() {
        String input = baseballConsole.userInputNumber();
        validateNumbers(input);
        validateLength(input);
        validateDifferentNumbers(input);
        addNumber(input);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void addNumber(String input) {
        for(String number : input.split("")) {
            numbers.add(Integer.parseInt(number));
        }
    }

    private void validateNumbers(String input) {
        try {
            int number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 외의 문자는 입력할 수 없습니다.");
        }
    }
    private void validateLength(String input) {
        if(input.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해야 합니다.");
        }
    }

    private void validateDifferentNumbers(String input) {
        Set<Character> set = new HashSet<>();
        char[] arr = input.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if(set.contains(arr[i])) {
                throw new IllegalArgumentException("중복되는 숫자를 입력할 수 없습니다.");
            }
            set.add(arr[i]);
        }
    }
}
