package baseball.controller;

import baseball.view.BaseballView;
import baseball.domain.Baseball;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BaseballController {
    private BaseballView baseballView;
    private Baseball baseball;

    public BaseballController() {
        this.baseballView = new BaseballView();
    }

    public void startGame() {
        List<Integer> list;
        baseball = new Baseball();
        do {
            baseballView.printGame();
            baseball.setUserNumber(Console.readLine());
            list = baseball.estimateScore();
            baseballView.printHint(list);
        } while (list.get(1) != 3);
    }

    public boolean resumeGame() {
        baseballView.resumeOrQuitGame();
        return baseball.inputControllNumber(Console.readLine());
    }

    public void controllGame() {
        do {
            startGame();
        } while (resumeGame());
    }
}
