package baseball.game;

import baseball.game.input.FinishInput;
import baseball.game.number.Number;
import baseball.game.number.RandomNumberGenerator;

public class BaseballGame {
    private final GamePrinter printer;
    private final GameScanner scanner;
    private final RandomNumberGenerator randomNumberGenerator;
    private final GameJudge judge;
    protected Number answerNumber;
    private Number playerInputNumber;
    private GameState gameState;

    public BaseballGame() {
        printer = new GamePrinter();
        scanner = new GameScanner();
        randomNumberGenerator = new RandomNumberGenerator();
        judge = new GameJudge();
    }

    public void initialize() {
        answerNumber = randomNumberGenerator.generate();

        printer.printStartMessage();
        gameState = GameState.INITIALIZED;
    }

    public void repeatRoundUntilThreeStrikes() {
        do {
            scanPlayerInputAndJudge();
        } while (isThreeStrike());
    }

    public void pauseAndAskIfPlayerFinishOrNot() {
        printer.printPauseMessage();
        gameState = GameState.PAUSED;

        if (scanner.readFinishInput() == FinishInput.QUIT_GAME) {
            finish();
        }
    }

    public boolean isNotFinished() {
        return gameState != GameState.FINISHED;
    }

    private boolean isThreeStrike() {
        return !judge.isThreeStrike(playerInputNumber, answerNumber);
    }

    private void scanPlayerInputAndJudge() {
        printer.printInputPrompt();
        playerInputNumber = scanner.readPlayerNumber();
        GameResult result = judge.countAndMakeResult(answerNumber, playerInputNumber);
        printer.printResult(result);
    }

    private void finish() {
        gameState = GameState.FINISHED;
        printer.printEndMessage();
    }
}
