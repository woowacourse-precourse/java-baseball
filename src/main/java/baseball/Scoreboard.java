package baseball;

import java.util.ArrayList;
import java.util.List;

public class Scoreboard {
    private final List<Integer> scoreBoard;

    public Scoreboard() {
        this.scoreBoard = new ArrayList<>(List.of(0, 0));
    }

    public Scoreboard(int ball, int strike) {
        this.scoreBoard = new ArrayList<>(List.of(ball, strike));
    }

    public void addBallPoint() {
        int ballPoint = this.getBallPoint();
        int newPoint = ballPoint + 1;

        this.setBallPoint(newPoint);
    }

    public void addStrikePoint() {
        int strikePoint = this.getStrikePoint();
        int newPoint = strikePoint + 1;

        this.setStrikePoint(newPoint);
    }

    public int getBallPoint() {
        return scoreBoard.get(0);
    }

    public int getStrikePoint() {
        return scoreBoard.get(1);
    }

    public List<Integer> toList() {
        return scoreBoard;
    }

    private void setBallPoint(int point) {
        scoreBoard.set(0, point);
    }

    private void setStrikePoint(int point) {
        scoreBoard.set(1, point);
    }


}
