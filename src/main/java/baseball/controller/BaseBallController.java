package baseball.controller;

import baseball.model.Score;
import baseball.service.BaseBallService;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

import java.util.Objects;

public class BaseBallController {

    public static final String CONTINUE_COMMAND = "1";
    private final BaseBallService baseBallService;

    public BaseBallController(BaseBallService baseBallService) {
        this.baseBallService = baseBallService;
    }

    public void run() {
        InputView.printStartMessage();
        gameStart();
    }

    private void gameStart() {
        baseBallService.init();
        Score initialScore = new Score(0, 0);
        playGameUntilEnd(initialScore);
        quitOrContinueGame();
    }

    private void playGameUntilEnd(Score score) {
        while (canContinueGame(score)) {
            InputView.printInputMessage();
            score = inputAndCompareAnswer();
            OutputView.printResultMessage(score);
        }
    }

    private static boolean canContinueGame(Score score) {
        return Objects.isNull(score) || score.canContinue();
    }

    private Score inputAndCompareAnswer() {
        String input = Console.readLine();
        return compareAnswer(input);
    }

    private Score compareAnswer(String input) {
        return baseBallService.compareAnswer(input);
    }

    private void quitOrContinueGame() {
        printQuitAndChoiceMessage();
        String input = Console.readLine();
        continueOrQuit(input);
    }

    private static void printQuitAndChoiceMessage() {
        OutputView.printQuitMessage();
        InputView.printChoiceMessage();
    }

    private void continueOrQuit(String input) {
        if (choiceContinue(input)) {
            gameStart();
        }
    }

    private static boolean choiceContinue(String input) {
        return input.equals(CONTINUE_COMMAND);
    }
}
