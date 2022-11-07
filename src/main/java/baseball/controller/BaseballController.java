package baseball.controller;

import baseball.view.BaseballView;
import baseball.domain.Baseball;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class BaseballController {
    private BaseballView baseballView;
    private Baseball baseball;
    private static final int STRIKE = 1;

    public BaseballController() {
        this.baseballView = new BaseballView();
    }

    private void controllGame() {
        List<Integer> hints;
        baseball = new Baseball();
        do {
            baseballView.printGame();
            baseball.inputUserNumber(Console.readLine());
            hints = baseball.playGame();
            baseballView.printHint(hints);
        } while (hints.get(STRIKE) != 3);
    }

    private boolean resumeGame() {
        baseballView.resumeOrQuitGame();
        return baseball.inputControllNumber(Console.readLine());
    }

    public void startGame() {
        do {
            controllGame();
        } while (resumeGame());
    }
}
