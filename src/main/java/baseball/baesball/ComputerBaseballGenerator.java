package baseball.baesball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.game.GameRule.*;

public class ComputerBaseballGenerator implements BaseballGenerator {
    @Override
    public Baseball generateBaseball() {
        List<Integer> baseball = new ArrayList<>();
        while (baseball.size() < BASEBALL_MAX_SIZE.getRule()) {
            int number = Randoms.pickNumberInRange(
                    BASEBALL_MIN_NUMBER.getRule(),
                    BASEBALL_MAX_NUMBER.getRule());
            if (!baseball.contains(number)) {
                baseball.add(number);
            }
        }
        return new Baseball(baseball);
    }
}
