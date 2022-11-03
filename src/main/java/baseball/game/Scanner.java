package baseball.game;

import baseball.constant.WarningMessage;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Scanner {

    public static List<Integer> getUserInput() {
        List<Integer> numbers = new ArrayList<>();
        String input = Console.readLine().trim();

        for(char ch : input.toCharArray()) {
            isDigit(ch);
            numbers.add(Character.getNumericValue(ch));
        }

        isThreeDigits(numbers);
        isExistDuplicate(numbers);

        return numbers;
    }

    private static void isDigit(char ch) {
        if(! Character.isDigit(ch)) {
            throw new IllegalArgumentException(WarningMessage.IllegalInputWarningMessage.getMessage());
        }
    }

    private static void isThreeDigits(List<Integer> numbers) {
        if(numbers.size() != 3) {
            throw new IllegalArgumentException(WarningMessage.IllegalInputWarningMessage.getMessage());
        }
    }

    private static void isExistDuplicate(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if(numberSet.size() != 3) {
            throw new IllegalArgumentException(WarningMessage.IllegalInputWarningMessage.getMessage());
        }
    }
}
