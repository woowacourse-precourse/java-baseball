package baseball;

import java.util.List;

public class Referee {
    private int ball;
    private int strike;

    public Referee() {
        ball = 0;
        strike = 0;
    }

    public boolean refereeCheck(List<Integer> userNum, List<Integer> computerNum) {
        ball = 0;
        strike = 0;
        strikeCount(userNum, computerNum);
        ballCount(userNum, computerNum);

        UserOutput.RefereeMessage(ball, strike);

        if (strike == 3) {
            UserOutput.userWinMessage();
            return false;
        }
        return true;
    }

    public void strikeCount(List<Integer> userNum, List<Integer> computerNum) {
        for (int i = 0; i < userNum.size(); i++) {
            if (userNum.get(i) == computerNum.get(i))
                strike++;
        }
    }

    public void ballCount(List<Integer> userNum, List<Integer> computerNum) {
        for (int i = 0; i < userNum.size(); i++) {
            for (int j = 0; j < computerNum.size(); j++) {
                if (userNum.get(i) == computerNum.get(j) && j != i)
                    ball++;
            }
        }
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
