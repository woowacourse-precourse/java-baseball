package baseball.controller;

import baseball.decision.Decision;
import baseball.game.Game;
import baseball.game.ResultOfBall;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.EnumMap;

public class GameController {
    private Game game;
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    public GameController() {
        this.game = new Game();
    }

    public GameController(int ballCount) {
        this.game = new Game(ballCount);
    }

    public void playRecurringGame() {
        Decision decision = Decision.PLAY;
        outputView.printGameStartingMessage();
        while (decision.equals(Decision.PLAY)) {
            playGameUntilEnd();
            decision = inputView.getUserCommandByConsole();
            settingGameForDecision(decision);
        }
    }

    private void playGameUntilEnd() {
        while (!game.isEndGame()) {
            EnumMap<ResultOfBall, Integer> gameResult = game.throwBall(inputView.getUserNBallByConsole(game.getBallSize()));
            outputView.printResultOfGame(gameResult);
        }
        outputView.printGameEndingMessage(game.getBallSize());
    }

    private void settingGameForDecision(Decision decision) {
        if (decision == Decision.PLAY) {
            game.restartGame();
        }
    }

}
