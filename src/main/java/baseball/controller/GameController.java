package baseball.controller;

import baseball.domain.Ball;
import baseball.domain.Balls;
import baseball.domain.Game;
import baseball.utils.InputHandler;
import baseball.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class GameController {

    Game game = new Game();
    List<Ball> ball = new ArrayList<>();
    Balls balls = new Balls(ball);

    InputHandler inputHandler = new InputHandler();
    OutputView outputView = new OutputView();

    public void playBall() {
        outputView.printStart();
        do {
            start();
        } while (restart());
    }

    public void start() {
        Balls computerBalls = balls.makeComputerBalls();
        while (game.strikeCount!=3) {
            compareBalls(computerBalls);
        }
        prepareRestart();
    }

    private void prepareRestart() {
        outputView.printEnd();
        game.initializeBallCount();
    }

    private void compareBalls(Balls computerBalls) {
        game.initializeBallCount();
        String playerInput = inputHandler.getUserBalls();
        Balls playerBalls = balls.makePlayerBalls(playerInput);
        game.checkBallCounts(playerBalls, computerBalls);
        outputView.printCount(game.printMessage());
    }

    public boolean restart() {
        int restart = inputHandler.getRestart();
        return restart==1;
    }
}
