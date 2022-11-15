package baseball.game;

import baseball.game.input.FinishInput;
import baseball.game.number.GameNumber;
import baseball.game.number.RandomNumberGenerator;

public class BaseballGame {
    private final GamePrinter printer;
    private final GameScanner scanner;
    private final RandomNumberGenerator randomNumberGenerator;
    private final GameJudge judge;
    protected GameNumber answer;
    private GameNumber playerInput;
    private GameState gameState;

    public BaseballGame() {
        printer = new GamePrinter();
        scanner = new GameScanner();
        randomNumberGenerator = new RandomNumberGenerator();
        judge = new GameJudge();
    }

    public void initialize() {
        answer = randomNumberGenerator.generate();

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
        return !judge.isThreeStrike(playerInput, answer);
    }

    private void scanPlayerInputAndJudge() {
        printer.printInputPrompt();
        playerInput = scanner.readPlayerNumber();
        GameResult result = judge.countAndMakeResult(answer, playerInput);
        printer.printResult(result);
    }

    private void finish() {
        gameState = GameState.FINISHED;
        printer.printEndMessage();
    }
}
