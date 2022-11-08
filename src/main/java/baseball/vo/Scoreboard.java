package baseball.vo;

import java.util.ArrayList;
import java.util.List;

public class Scoreboard {
    private final String KOREAN_EXPRESS_BALL = "볼";
    private final String KOREAN_EXPRESS_STRIKE = "스트라이크";
    private final String KOREAN_EXPRESS_NOTHING = "낫싱";

    private final List<Integer> scoreboard;

    public Scoreboard() {
        this.scoreboard = new ArrayList<>(List.of(0, 0));
    }

    public Scoreboard(int ball, int strike) {
        this.scoreboard = new ArrayList<>(List.of(ball, strike));
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
        return this.scoreboard.get(0);
    }

    public int getStrikePoint() {
        return this.scoreboard.get(1);
    }


    public List<Integer> toList() {
        return this.scoreboard;
    }

    private void setBallPoint(int point) {
        this.scoreboard.set(0, point);
    }

    private void setStrikePoint(int point) {
        this.scoreboard.set(1, point);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        int ballPoint = this.getBallPoint();
        int strikePoint = this.getStrikePoint();

        result.append(parseStringFromPoint(ballPoint, KOREAN_EXPRESS_BALL));

        if (ballPoint > 0 && strikePoint > 0) {
            result.append(" ");
        }

        result.append(parseStringFromPoint(strikePoint, KOREAN_EXPRESS_STRIKE));

        if (result.length() == 0) {
            result.append(KOREAN_EXPRESS_NOTHING);
        }

        return result.toString();
    }

    private String parseStringFromPoint(int point, String unit) {
        StringBuilder result = new StringBuilder();

        if (point > 0) {
            result.append(point).append(unit);
        }

        return result.toString();
    }
}
