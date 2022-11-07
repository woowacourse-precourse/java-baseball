package baseball;

import static baseball.util.BallCode.*;

import baseball.model.Computer;
import baseball.model.Player;
import baseball.util.BallCode;
import baseball.view.InputView;
import baseball.view.OutputVIew;

public class GameController {
    private static final int TARTGET_NUMBER = 3;
    private static final InputView inputView = new InputView();
    private static final OutputVIew outputView = new OutputVIew();
    private static final Computer computer = new Computer();
    private static final Player player = new Player();

    private boolean exitGame;
    private int strike = 0;
    private int ball = 0;

    public void run() {
        outputView.startGame();

        do {
            resetStates();
            Playing();
            exitGame = inputView.selectReStartGame();
        }while (exitGame);

        outputView.endGame();
    }
    private void resetStates(){
        this.exitGame = false;
        this.strike = 0;
        this.ball = 0;
    }
}