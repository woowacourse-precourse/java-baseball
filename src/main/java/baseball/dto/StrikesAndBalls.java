package baseball.dto;

import java.util.List;

public class StrikesAndBalls {
    private List<Integer> strikesAndBalls;

    public StrikesAndBalls() {
        this.strikesAndBalls = List.of(0, 0);
    }

    public void setStrikesAndBalls(List<Integer> strikesAndBalls) {
        this.strikesAndBalls = strikesAndBalls;
    }

    public List<Integer> getStrikesAndBalls() {
        return strikesAndBalls;
    }

    public int getStrikes() {
        return strikesAndBalls.get(0);
    }
}
