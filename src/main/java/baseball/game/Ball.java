package baseball.game;

import java.util.ArrayList;
import java.util.List;

public class Ball {
    private List<Integer> ballData;

    public Ball() {
    }

    public Ball(List<Integer> ball) {
        ballData = new ArrayList<>(ball);
    }

    public List<Integer> getBallData() {
        return new ArrayList<>(ballData);
    }

}
