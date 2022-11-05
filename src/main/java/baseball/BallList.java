package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BallList {
    private List<Ball> ballList;

    public BallList(List<Ball> ballList) {

    }

    private void checkOverlap(List<Ball> ballList) {
        Set<Ball> ballListSet = new HashSet<>(ballList);
        if (ballListSet.size() != 3) {
            throw new IllegalArgumentException("각 자리 숫자가 다른 값이어야 합니다.")
        }

    }

}
