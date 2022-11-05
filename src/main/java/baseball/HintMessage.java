package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedHashSet;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;

import baseball.Application;

public class HintMessage {
    final static String STRIKE = "스트라이크";
    static int strike_Score = 0;

    final static String BALL = "볼 ";
    static int ball_Score = 0;

    final static String NOTHING = "낫싱";
    static boolean isFinish = true;
    int inputNumber = 0;
    public boolean checkPoint(List<Integer> user, List<Integer> com) {
        strike_Score = 0;
        ball_Score = 0;
        if (!user.equals(com)) {
            checkStrike(user, com);
            getHint();
        }
        if (user.equals(com)) {
            isFinish = isFinishGame();
            return isFinish;
        }
        return true;
    }

    public void checkStrike(List<Integer> user, List<Integer> com) {
        for (int i = 0; i < 3; i++) {
            if (user.get(i) == com.get(i)) {
                strike_Score++;
            } else if (user.get(i) != com.get(i)) {
                int number = user.get(i);
                ball_Score = checkBall(number, com);
            }
        }
    }

    public int checkBall(int number, List<Integer> com) {
        System.out.println("number = " + number);
        if (com.contains(number)) {
            ball_Score++;
        }
        return ball_Score;
    }

    public void getHint() {
        if (ball_Score > 0) {
            System.out.print(ball_Score + BALL);
        }
        if (strike_Score > 0) {
            System.out.print(strike_Score + STRIKE);
        }
        if (ball_Score + strike_Score == 0) {
            System.out.print(NOTHING);
        }
        System.out.println();
    }

    public boolean isFinishGame() {
        System.out.println("3" + STRIKE);
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        isFinish = false;
        return isFinish;
    }
}
