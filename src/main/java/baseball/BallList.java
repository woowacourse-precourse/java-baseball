package baseball;

import camp.nextstep.edu.missionutils.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class BallList {
    private List<Ball> ballList;

    public BallList(List<Ball> ballList) {
        checkOverlap(ballList);
        this.ballList = ballList;
    }

    public static BallList computerBallList() {
        List<Ball> ballList = new ArrayList<>();

        while (ballList.size()!=3) {
            Ball ball = new Ball(Randoms.pickNumberInRange(1,9));
            if (!ballList.contains(ball)) {
                ballList.add(ball);
            }
        }

        return new BallList(ballList);
    }

    public static BallList userBallList() {
        List<Ball> ballList = new ArrayList<>();

        while (ballList.size()==0) {
            String userBall = readLine();
            checkUserLength(userBall);
            for (int i=0;i<3;i++) {
                Ball ball = new Ball(Character.getNumericValue(userBall.charAt(i)));
                ballList.add(ball);
            }
        }

        return (BallList) ballList;
    }

    private void checkOverlap(List<Ball> ballList) {
        Set<Ball> ballListSet = new HashSet<>(ballList);
        if (ballListSet.size() != 3) {
            throw new IllegalArgumentException("각 자리 숫자가 다른 값이어야 합니다.");
        }
    }

    private static void checkUserLength(String userBall) {
        if (userBall.length() != 3) {
            throw new IllegalArgumentException("입력값의 길이가 3이 아닙니다.");
        }
    }



}
