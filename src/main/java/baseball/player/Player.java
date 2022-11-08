package baseball.player;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {

    private final List<String> selectBalls = new ArrayList<>();

    public abstract void selectBalls();

    public List<String> getSelectBalls() {
        return new ArrayList<>(selectBalls);
    }

    public void clearSelectBalls() {
        selectBalls.clear();
    }

    int getBallsNumber() {
        return selectBalls.size();
    }

    boolean isSelectBall(String ball) {
        return selectBalls.contains(ball);
    }

    void selectBall(String ball) {
        selectBalls.add(ball);
    }
}
