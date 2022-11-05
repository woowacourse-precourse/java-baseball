package baseball;

import java.util.List;

public class Check {

    private int strike;
    private int ball;

    public void Check(List<Ball> computer, List<Ball> user) {
        this.strike = 0;
        this.ball = 0;

        for (int i=0;i<3;i++) {
            if (computer.get(i).equals(user.get(i))) {
                strike++;
            } else if (computer.contains(user.get(i))) {
                ball++;
            }
        }
    }
}
