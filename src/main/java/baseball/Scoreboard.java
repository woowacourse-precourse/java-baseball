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
        this.addBallPoint(1);
    }

    private void addBallPoint(int point) {
        this.setBallPoint(this.getBallPoint() + point);
    }

    public void addStrikePoint() {
        this.addStrikePoint(1);
    }

    private void addStrikePoint(int point) {
        this.setStrikePoint(this.getStrikePoint() + point);
    }

    public void addAllPoint(Scoreboard scoreboard) {
        this.addStrikePoint(scoreboard.getStrikePoint());
        this.addBallPoint(scoreboard.getBallPoint());
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
