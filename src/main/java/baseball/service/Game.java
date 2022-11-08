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
    private boolean isEnd;

    public Game() {
        this.rule = new Rule();
        this.isEnd = false;
    }

    public void run() {
        InputView.printStartMessage();
        while (true) {
            isEnd = process();
            if(isEnd) {
                return;
            }
        }

    }

    private void init() {
        rule.generateRandomNumber();
    }

    private List<Integer> getResult() {
        rule.getNumber();
        return rule.decideStrikeOrBall();
    }

    private boolean process() {
        init();
        List<Integer> result = getResult();
        //다 맞았다면
        if (result.get(0) == SUCCESS) {
            int reStartFlag = processSucess();
            if (reStartFlag == EXIT) {
                return true;
            }
            if (reStartFlag == RESTART) {
                return false;
            }
        }

        if(result.get(0) == NOTHING && result.get(1) == NOTHING) {
            OutputView.printNothingMessage();
            return false;
        }

        OutputView.printHintMessage();
        return false;
    }

    private int processSucess() {
        OutputView.printSuccessMessage();
        return InputView.reStart();
    }
}
