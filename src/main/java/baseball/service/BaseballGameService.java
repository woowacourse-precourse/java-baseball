package baseball.service;

import baseball.model.GameNumber;
import baseball.model.GameResult;
import baseball.model.Umpire;

public class BaseballGameService {
    private final NumberGenerator numberGenerator = new NumberGenerator();
    private Umpire umpire;

    public void newGame() {
        GameNumber answer = new GameNumber(numberGenerator.createRandomNumbers());
        umpire = new Umpire(answer);
    }

    public GameResult playGame(String playerInputNumbers) {
        GameNumber playerGameNumber = GameNumber.from(playerInputNumbers);

        return umpire.decision(playerGameNumber);
    }
}
