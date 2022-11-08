package baseball.controller;

import baseball.domain.computer.Computer;
import baseball.domain.game.GameHint;
import baseball.domain.game.Result;
import baseball.domain.computer.generator.NumberGenerator;
import baseball.domain.computer.generator.RandomNumberGenerator;
import baseball.domain.player.Player;
import baseball.utils.Validator;
import baseball.view.GameView;
import camp.nextstep.edu.missionutils.Console;

import static baseball.utils.Constants.*;

public class GameController {
    private GameView gameView;
    private Player player;
    private Computer computer;

    public GameController() {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        this.computer = new Computer(numberGenerator);
        this.player = new Player();
        this.gameView = new GameView();
    }

    public void start() {
        gameView.startGame();
        do {
            play();
        } while (isRestart());
    }

    private void play() {
        Result result;

        computer.setRandomNumbers();
        do {
            gameView.receivePlayerInput(player);
            result = Result.of(GameHint.compare(computer, player));
            gameView.printResult(result);
        } while (!result.isThreeStrike());

        gameView.printSuccessAndRestart();
    }

    private boolean isRestart() {
        String input = Console.readLine();
        Validator.validateRestartInput(input);

        return input.equals(GAME_RESTART);
    }
}
