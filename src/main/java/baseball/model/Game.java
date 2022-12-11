package baseball.model;

import baseball.dto.ReplayNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Game {

    private Computer computer;
    private User user;
    private Round round;

    public Game() {}

    public void turnOnGame(Computer computer, User user) {
        this.computer = computer;
        this.user = user;
        this.round = new Round();
        OutputView.printGameStart();
    }

    public void startNewGame() {
        this.computer.pickRandomNumbers();
        playGame();
        OutputView.printGameEnd();
    }

    private void playGame() {
        do {
            round.startNewRound(user, computer);
        } while (!round.isThreeStrike());
    }

    public boolean replayGame() {
        OutputView.printReplayGame();
        int inputInt = InputView.readInt();
        ReplayNumber replayNumber = new ReplayNumber(inputInt);
        return replayNumber.isReplay();
    }
}
