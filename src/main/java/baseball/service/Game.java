package baseball.service;

import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class Game {
    private static final int NOTHING = 0;
    private static final int RESTART = 1;
    private static final int EXIT = 2;
    private static final int SUCCESS = 3;

    private final Rule rule;
    private List<Integer> result;
    private boolean isEnd;

    public Game() {
        this.rule = new Rule();
        this.isEnd = false;
    }

    public void run() {
        OutputView.printStartMessage();
        init();
        while (true) {
            isEnd = process();
            if (isEnd) {
                return;
            }
        }

    }

    private void init() {
        rule.generateRandomNumber();
    }

    private boolean process() {
        result = getResult();

        if (result.get(0) == SUCCESS) {
            int reStartFlag = processSucess();
            if (reStartFlag == EXIT) {
                return true;
            }
            if (reStartFlag == RESTART) {
                init();
                return false;
            }
        }
        if (result.get(0) == NOTHING && result.get(1) == NOTHING) {
            OutputView.printNothingMessage();
            return false;
        }
        if (result.get(0) == NOTHING && result.get(1) > NOTHING) {
            OutputView.printOnlyBallMessage();
            return false;
        }

        OutputView.printHintMessage(result.get(0), result.get(1));
        return false;
    }

    private List<Integer> getResult() {
        OutputView.printInputMessage();
        rule.getNumberByPlayer();
        return rule.decideStrikeOrBall();
    }

    private int processSucess() {
        OutputView.printOnlyStrikeMessage();
        OutputView.printSuccessMessage();
        OutputView.printReStartMessage();
        String input = InputView.read();
        if (Validation.isValidReStart(input)) {
            return Integer.parseInt(input);
        }
        return Integer.parseInt(input);
    }
}
