package baseball.service;

import baseball.model.GameNumber;
import baseball.model.GameResult;
import baseball.model.Umpire;

public class BaseballGameService {
    private final NumberGenerator numberGenerator = new NumberGenerator();
    private Umpire umpire;

    public void newGame(String playerInputNumbers) {
        GameNumber computerGameNumber = new GameNumber(numberGenerator.createRandomNumbers());
        GameNumber playerGameNumber = GameNumber.from(playerInputNumbers);

        umpire = new Umpire(computerGameNumber, playerGameNumber);
    }

    public GameResult playGame(String playerInputNumbers) {
        GameNumber playerGameNumber = GameNumber.from(playerInputNumbers);
        umpire.changePlayerGameNumber(playerGameNumber);

        return umpire.decision();
    }
}
