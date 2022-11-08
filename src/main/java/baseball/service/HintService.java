package baseball.service;

import baseball.domain.Hint;

import java.util.ArrayList;
import java.util.List;

public class HintService {
    public static Hint generateHint(List<Integer> computerNumber, List<Integer> playerNumber) {
        Hint hint = new Hint(0,0);

        int strikeNum = isStrike(computerNumber, playerNumber);
        int ballNum = isBall(computerNumber, playerNumber) - strikeNum;

        hint.setStrike(strikeNum);
        hint.setBall(ballNum);

        return hint;
    }

    public static int isStrike(List<Integer> computerNumber, List<Integer> playerNumber){
        int strike = 0;

        for (int i = 0; i < 3; i++) {
            if (playerNumber.get(i).equals(computerNumber.get(i))) {
                strike++;
            }
        }

        return  strike;
    }

    public static int isBall(List<Integer> computerNumber, List<Integer> playerNumber){
        int ball = 0;

        for (Integer num : playerNumber) {
            if (computerNumber.contains(num)) {
                ball++;
            }
        }

        return ball;
    }
}
