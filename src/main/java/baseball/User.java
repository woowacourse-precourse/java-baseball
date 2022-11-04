package baseball;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final List<Integer> numbers;

    public User() {
        numbers = new ArrayList<>();
    }

    public void makeNewNumbers(String input) {
        numbers.clear();

        for (int index = 0; index < input.length(); index++) {
            char digit = input.charAt(index);
            int number = Character.getNumericValue(digit);
            numbers.add(number);
        }
    }

    public int getNumber(int index) {
        return numbers.get(index);
    }
}
