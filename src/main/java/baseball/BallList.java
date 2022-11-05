package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BallList {
    private List<Ball> ballList;

    public BallList(List<Ball> ballList) {
        checkOverlap(ballList);
        this.ballList = ballList;
    }

    public static BallList RandomBallList() {
        List<Ball> ballList = new ArrayList<>();

        while (ballList.size()!=3) {
            Ball ball = new Ball(Randoms.pickNumberInRange(1,9));
            if (!ballList.contains(ball)) {
                ballList.add(ball);
            }
        }

        return new BallList(ballList);
    }

    private void checkOverlap(List<Ball> ballList) {
        Set<Ball> ballListSet = new HashSet<>(ballList);
        if (ballListSet.size() != 3) {
            throw new IllegalArgumentException("각 자리 숫자가 다른 값이어야 합니다.");
        }
    }



}
