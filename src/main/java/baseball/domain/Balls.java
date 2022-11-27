package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Balls {

    private static final int BALLS_LENGTH = 3;

    private List<Ball> balls;

    public Balls(List<Ball> balls) {
        this.balls= balls;
    }

    public boolean contains(Ball ball) {
        return balls.contains(ball);
    }

    public Ball get(int index) {
        return this.balls.get(index);
    }

    public int indexOf(Ball ball) {
        return balls.indexOf(ball);
    }

    public int size() {
        return balls.size();
    }

    public Balls makeComputerBalls() {
        List<Ball> comBalls = new ArrayList<>();
        while (comBalls.size() != BALLS_LENGTH) {
            Ball ball = new Ball(Randoms.pickNumberInRange(1, 9));
            if (!comBalls.contains(ball)) {
                comBalls.add(ball);
            }
        }
        return new Balls(comBalls);
    }

    public Balls makePlayerBalls(String playerInput) {
        List<Ball>playerBalls = new ArrayList<>();
        for(int i=0;i<playerInput.length();i++){
            Ball ball = new Ball(Integer.parseInt(String.valueOf(playerInput.charAt(i))));
            playerBalls.add(ball);
        }
        return new Balls(playerBalls);
    }

    @Override
    public boolean equals(Object obj) {
        Balls balls = (Balls) obj;
        return this.balls.equals(balls.balls);
    }
}
