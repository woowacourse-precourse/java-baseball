package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {
    List<Integer> user = new ArrayList<>();

    public User() {
        String threeNumber = Console.readLine();
        check_length(threeNumber);


        for (Character letter : threeNumber.toCharArray()) {
            check_is_digit(letter);

            int num = Character.getNumericValue(letter);
            check_is_zero(num);
            check_already_contains_value(num);
            user.add(num);
        }

    }


    private void check_length(String input) {
        if (input.length() != 3) throw new IllegalArgumentException();
    }

    private void check_is_digit(Character input) {
        if (!Character.isDigit(input)) throw new IllegalArgumentException();
    }

    private void check_is_zero(int input) {
        if (input == 0) throw new IllegalArgumentException();
    }

    private void check_already_contains_value(int input) {
        if (user.contains(input)) throw new IllegalArgumentException();
    }

    public List<Integer> get_number() {
        return user;
    }
}
