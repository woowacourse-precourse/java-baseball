package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerBallGenerator {

    public List<Integer> createComputerBalls() {
        List<Integer> computerBalls = new ArrayList<>();
        while (computerBalls.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerBalls.contains(randomNumber)) {
                computerBalls.add(randomNumber);
            }
        }
        return computerBalls;
    }

}
