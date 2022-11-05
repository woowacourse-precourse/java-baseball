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
        isValidRange(num);
        hasDistinctDigits(num);
    }

    private void isValidRange(int num) {
        if (100 <= num && num < 1000) {
            return;
        }
        throw new IllegalArgumentException("3자리 수를 입력해주세요.");
    }

    private void hasDistinctDigits(int num) {
        List<Integer> seperatedDigits = separateToDigits(num);
        Integer firstDigit = seperatedDigits.get(0);
        Integer secondDigit = seperatedDigits.get(1);
        Integer thirdDigit = seperatedDigits.get(2);

        if (firstDigit.equals(secondDigit) || secondDigit.equals(thirdDigit) || firstDigit.equals(thirdDigit)) {
            throw new IllegalArgumentException("서로 다른 3자리 수를 입력해주세요.");
        }
    }

    private List<Integer> separateToDigits(int num) {
        Integer firstDigit = num / 100;
        Integer secondDigit = (num % 100) / 10;
        Integer thirdDigit = num % 10;
        return List.of(firstDigit, secondDigit, thirdDigit);
    }
}
