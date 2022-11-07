package computer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Judgment {
    private boolean isStrike(List<Integer> randomNumber, List<Integer> userNumber, int index) {
        if (Objects.equals(randomNumber.get(index), userNumber.get(index))) {
            return true;
        }
        return false;
    }

    private boolean isBall(List<Integer> randomNumber, List<Integer> userNumber, int index) {
        for (int randomNum : randomNumber) {
            if (randomNum == userNumber.get(index)) {
                return true;
            }
        }
        return false;
    }

    public List<Integer> judgeResult(List<Integer> randomNumber, List<Integer> userNumber) {
        List<Integer> result = new ArrayList<Integer>(List.of(0, 0));
        for (int index = 0; index < userNumber.size(); index++) {
            if (isStrike(randomNumber, userNumber, index)) {
                int strike = result.get(0) + 1;
                result.set(0, strike);
                continue;
            }
            if (isBall(randomNumber, userNumber, index)) {
                int ball = result.get(1) + 1;
                result.set(1, ball);
            }
        }
        return result;
    }
}
