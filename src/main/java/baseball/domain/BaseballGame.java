package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class BaseballGame {
    private List<Integer> baseball;

    public void generate() {
        List<Integer> baseball = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        this.baseball = baseball;
    }

    public List<Integer> getBaseball() {
        return baseball;
    }
}
