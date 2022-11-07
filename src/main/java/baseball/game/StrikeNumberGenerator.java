package baseball.game;

import baseball.object.StrikeNumber;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class StrikeNumberGenerator {

    public static StrikeNumber getStrikeNumber() {

        List<Integer> number = new ArrayList<>();

        while (number.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!number.contains(randomNumber)) {
                number.add(randomNumber);
            }
        }

        return new StrikeNumber(number);
    }
}
