package baseball.domain;

import java.util.List;

public class Rule {
    private final boolean gameOver;

    public Rule() {
        gameOver = false;
    }

    public String getHint(List<Integer> numbers) {
        return "";
    }

    public String gameOver() {
        return "";
    }

    public boolean isGameOver() {
        return gameOver;
    }
}
