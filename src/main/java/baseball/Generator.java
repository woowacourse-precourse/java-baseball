package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.Set;

public class Generator {

    private static final int BALL_LENGTH = 3;

    private Set<Character> ballCounter;

    public String generateRandomNumber() {
        StringBuilder counterpartNumber = new StringBuilder();
        ballCounter = new HashSet<>();

        while (ballCounter.size() < BALL_LENGTH) {
            char number = integerToCharacter(Randoms.pickNumberInRange(1, 9));

            if (ballCounter.contains(number)) {
                continue;
            }

            counterpartNumber.append(number);
            ballCounter.add(number);
        }

        return counterpartNumber.toString();
    }

    private char integerToCharacter(int integer) {
        return Integer.toString(integer).charAt(0);
    }

}
