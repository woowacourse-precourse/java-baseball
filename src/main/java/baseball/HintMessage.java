package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedHashSet;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;

import baseball.Application;

public class HintMessage {
    private int strike_Score = 0;
    private int ball_Score = 0;
    public boolean checkPoint(List<Integer> user, List<Integer> com) {
        strike_Score = 0;
        ball_Score = 0;
        if (!user.equals(com)) {
            checkStrike(user, com);
            getHint();
        }
        if (user.equals(com)) {
            isFinishGame();
            return false;
        }
        return true;
    }

    public void checkStrike(List<Integer> user, List<Integer> com) {
        for (int i = 0; i < SystemMessage.NUMBER_SIZE; i++) {
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
            System.out.print(ball_Score + SystemMessage.BALL);
        }
        if (strike_Score > 0) {
            System.out.print(strike_Score + SystemMessage.STRIKE);
        }
        if (ball_Score + strike_Score == 0) {
            System.out.print(SystemMessage.NOTHING);
        }
        System.out.println();
    }

    public boolean isFinishGame() {
        System.out.println(SystemMessage.GAME_END_STRIKE);
        System.out.println(SystemMessage.GAME_END_MESSAGE);
        return false;
    }
}
