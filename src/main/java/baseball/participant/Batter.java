package baseball.participant;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Batter {

    public String readyToHitNumberBall() {
        List<Integer> hitDigits = new ArrayList<>();
        while (hitDigits.size() != 3) {
            readyHitDigit(hitDigits);
        }
        return hitDigits.stream().map(String::valueOf).collect(Collectors.joining(""));
    }

    private void readyHitDigit(List<Integer> hitDigits) {
        int randomDigit = Randoms.pickNumberInRange(1, 9);
        if (!hitDigits.contains(randomDigit)) {
            hitDigits.add(randomDigit);
        }
    }
}
