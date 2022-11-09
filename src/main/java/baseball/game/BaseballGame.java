package baseball.game;

import baseball.game.input.FinishInput;
import baseball.game.number.Number;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private final GamePrinter printer;
    private final GameScanner scanner;
    private final GameJudge judge;
    protected Number answerNumber;
    private Number playerInputNumber;
    private GameState gameState;

    public BaseballGame() {
        printer = new GamePrinter();
        scanner = new GameScanner();
        judge = new GameJudge();
    }

    public void initialize() {
        generateRandomNumber();

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

    private void generateRandomNumber() {
        List<Integer> digits = generateDigitsForNumber();
        answerNumber = new Number(digits);
    }

    private List<Integer> generateDigitsForNumber() {
        List<Integer> digits = new ArrayList<>();
        while (digits.size() < Number.FULL_SIZE) {
            addUniqueRandomDigit(digits);
        }
        return digits;
    }

    private void addUniqueRandomDigit(List<Integer> digits) {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if (!digits.contains(randomNumber)) {
            digits.add(randomNumber);
        }
    }
}
