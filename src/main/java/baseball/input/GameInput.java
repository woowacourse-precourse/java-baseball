package baseball.input;

import java.util.List;

public class GameInput {
    public final Integer first;
    public final Integer second;
    public final Integer third;

    public GameInput(int num) {
        validateInput(num);

        List<Integer> separatedDigits = separateToDigits(num);
        first = separatedDigits.get(0);
        second = separatedDigits.get(1);
        third = separatedDigits.get(2);
    }

    private void validateInput(int num) {
    }


    private List<Integer> separateToDigits(int num) {
        Integer firstDigit = num / 100;
        Integer secondDigit = (num % 100) / 10;
        Integer thirdDigit = num % 10;
        return List.of(firstDigit, secondDigit, thirdDigit);
    }
}
