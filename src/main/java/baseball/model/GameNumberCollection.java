package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class GameNumberCollection {
    private final List<GameNumber> gameNumbers;

    public GameNumberCollection(List<Integer> numbers) {
        this.gameNumbers = setGameNumbers(numbers);
    }

    private List<GameNumber> setGameNumbers(List<Integer> numbers) {
        List<GameNumber> gameNumbers = new ArrayList<>();
        for(int index = 0; index < numbers.size(); index++) {
            GameNumber instance = new GameNumber(index, numbers.get(index));
            gameNumbers.add(instance);
        }
        return gameNumbers;
    }

    public int countBalls(GameNumberCollection otherObj) {
        return (int) gameNumbers.stream()
                .filter(otherObj::hasBallOf)
                .count();
    }

    private boolean hasBallOf(GameNumber otherGameNumber) {
        return gameNumbers.stream()
                .anyMatch(gameNumber -> gameNumber.hasOnlyDifferentIndexWith(otherGameNumber));
    }
}
