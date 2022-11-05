package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseBall {
    private static List<Integer> answer = new ArrayList<>();

    public BaseBall() {
        this.answer = Randoms.pickUniqueNumbersInRange(0, 9, 3);
    }
}
