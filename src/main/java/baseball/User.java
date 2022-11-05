package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static baseball.RuleConst.*;

public class User {
    private List<Integer> numbers;

    public User() {
        this.numbers = new ArrayList<>(List.of(0, 0, 0));
    }

    private void setNumbers(String number) {
        for (int index = 0; index < number.length(); index++) {
            numbers.set(index, Integer.valueOf(number.substring(index, index + 1)));
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void generateNumber() {
        this.numbers = new ArrayList<>(List.of(0, 0, 0));

        System.out.println("숫자를 입력해주세요 : ");

        String number = Console.readLine();

        isLegalNumber(number);

        setNumbers(number);
    }

    private void isLegalNumber(String number) {
        try {
            Integer.valueOf(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if ((number.charAt(0) == '0') || number.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }

        for (int i = 1; i < 10; i++) {
            char characterized = (char) (i + 48);
            if (countNumber(number, characterized) > 1) {
                throw new IllegalArgumentException();
            }
        }
    }

    private long countNumber(String number, char target) {
        return number.chars().filter(ch -> ch == target).count();
    }
}
