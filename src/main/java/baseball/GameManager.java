package baseball;

public class GameManager {
    private final InputView inputView;
    private final OutputView outputView;

    private GameNumber oppositeNumber;

    public GameManager() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void runGame() {
        do {
            outputView.printStartGameAlert();
            oppositeNumber = GameNumber.getRandomInstance();

            repeatGetInputAndCompare();
        } while(getAndProcessRestartInput());
    }

    private void repeatGetInputAndCompare() {
        BallStrikeResult result;
        do {
            GameNumber inputNumber = getAndProcessGameNumberInput();
            result = inputNumber.countBallStrike(oppositeNumber);
            outputView.printBallStrikeResult(result);
        } while(!result.doesWin());
        outputView.printGameEndAlert();
    }

    private GameNumber getAndProcessGameNumberInput() {
        outputView.printInputNumberAlert();
        return inputView.readGameNumberInput();
    }

    private boolean getAndProcessRestartInput() {
        outputView.printAfterGameEndAlert();
        return inputView.readRestartInput().shouldGameRestart();
    }
}
