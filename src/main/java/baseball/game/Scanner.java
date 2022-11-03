package baseball.game;

import baseball.util.Validator;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Scanner {

    public static List<Integer> getUserInput() {
        List<Integer> numbers = new ArrayList<>();
        String input = Console.readLine().trim();

        for(char ch : input.toCharArray()) {
            Validator.isDigit(ch);
            numbers.add(Character.getNumericValue(ch));
        }

        Validator.isValidNumber(numbers);

        return numbers;
    }
}
