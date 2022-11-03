package baseball;

import java.util.List;

public class Referee {

    int strike = 0;
    int ball = 0;
    Ball comBall = new Ball();
    Ball humanBall = new Ball();

    public Referee() {

    }

    public void compareStrike(Ball comBall, Ball humanBall) {
        for (int i = 0; i < comBall.size(); i++) {
            if (humanBall.contains(comBall.get(i)) && humanBall.indexOf(comBall.get(i)) != i) {
                ball++;
            }
        }
    }

    public void compareBall(Ball comBall, Ball humanBall) {
        for (int i = 0; i < comBall.size(); i++) {
            if (humanBall.contains(comBall.get(i)) && humanBall.indexOf(comBall.get(i)) == i) {
                strike++;
            }
        }
    }
}
