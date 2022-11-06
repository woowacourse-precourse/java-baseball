package baseball;

import java.util.List;

public class Game {

    private static final int NUMBER_LENGTH = 3;

    private int countStrike(List<Character> computerNumber, List<Character> userNumber) {
        int strike = 0;
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (computerNumber.get(i).equals(userNumber.get(i))) {
                strike += 1;
            }
        }
        return strike;
    }
}
