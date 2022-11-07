package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static baseball.RuleConst.*;

public class User {
    private List<Integer> numbers;

    public User() {
        this.numbers = new ArrayList<>(List.of(0, 0, 0));
    }

    private void setNumbers(String number) {
        numbers = Arrays.stream(number.split("")).map(Integer::parseInt).collect(Collectors.toList());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private boolean isZeroAtFirst(String number) {
        return number.charAt(0) == '0';
    }

    private boolean checkLength(String number) {
        return number.length() == NUMBER_LENGTH;
    }

    private long countNumber(String number, char target) {
        return number.chars().filter(ch -> ch == target).count();
    }

    private boolean anyDuplicated(String number) {
        for (int i = 1; i < 10; i++) {
            char characterized = (char) (i + 48);
            if (countNumber(number, characterized) > 1) {
                return true;
            }
        }
        return false;
    }

    private void isLegalNumber(String number) {
        if (number.isBlank() || isZeroAtFirst(number) || !checkLength(number) || anyDuplicated(number)) {
            throw new IllegalArgumentException();
        }

        try {
            Integer.valueOf(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public void generateNumber() {
        this.numbers = new ArrayList<>(List.of(0, 0, 0));

        System.out.println("숫자를 입력해주세요 : ");
        String number = Console.readLine();

        isLegalNumber(number);
        setNumbers(number);
    }
}
