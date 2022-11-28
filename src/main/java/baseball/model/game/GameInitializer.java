package baseball.model.game;

import baseball.model.number.NumberCollection;
import baseball.model.number.RandomNumberGenerator;

import java.util.List;
import java.util.Objects;

public enum GameInitializer {

    INSTANCE;
    private static final RandomNumberGenerator randomNumberGenerator = RandomNumberGenerator.INSTANCE;

    GameInitializer() {
    }

    public static Game initializeGame() {
        List<Integer> numbers = randomNumberGenerator.generate();
        NumberCollection computerNumbers = new NumberCollection(numbers);
        return new Game(computerNumbers);
    }
}
