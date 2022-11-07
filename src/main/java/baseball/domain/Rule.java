package baseball.domain;

import java.util.Set;

public class Rule {
    private final boolean gameOver;

    public Rule() {
        gameOver = false;
    }

    public String getHint(Set<Integer> numbers) {
        return "";
    }

    public String gameOver() {
        return "";
    }

    public boolean isGameOver() {
        return gameOver;
    }
}
