package baseball;

import static baseball.Const.BALL_LENGTH;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.Set;

public class Generator {

    private Set<Character> overlapChecker;

    public String generateRandomNumber() {
        StringBuilder counterpartNumber = new StringBuilder();
        overlapChecker = new HashSet<>();

        while (overlapChecker.size() < BALL_LENGTH) {
            char number = generateRandomNumberFrom1To9();

            if (overlapChecker.add(number)) {
                counterpartNumber.append(number);
            }
        }

        return counterpartNumber.toString();
    }

    public Set<Character> getOverlapChecker() {
        return this.overlapChecker;
    }

    private char generateRandomNumberFrom1To9() {
        return Integer.toString(Randoms.pickNumberInRange(1, 9)).charAt(0);
    }

}
