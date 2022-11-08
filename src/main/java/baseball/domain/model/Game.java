package baseball.domain.model;

import java.util.List;

public class Game {
    private final List<Integer> gameNumbers;

    public Game(List<Integer> gameNumbers) {
        this.gameNumbers = gameNumbers;
    }

    public List<Integer> getGameNumbers() {
        return gameNumbers;
    }
}
