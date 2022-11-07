package baseball.datamodel;

import java.util.ArrayList;
import java.util.List;

public class UserNumber {
    private static final int MAX_LENGTH = 3;
    private List<Integer> numbers;

    public UserNumber() {
    }

    public void checkNumber(String input) {
        numbers = new ArrayList<>();
        int num;

        if (input.length() != MAX_LENGTH) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < MAX_LENGTH; i++) {
            num = Character.getNumericValue(input.charAt(i));
            if (num < 1 || num > 9) {
                throw new IllegalArgumentException();
            }
            numbers.add(num);
        }

        if (numbers.get(0) == numbers.get(1) || numbers.get(0) == numbers.get(2) || numbers.get(1) == numbers.get(2)) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
