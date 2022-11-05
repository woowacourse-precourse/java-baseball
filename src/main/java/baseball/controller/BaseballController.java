package baseball.controller;

import baseball.view.BaseballView;
import baseball.domain.Baseball;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BaseballController {
    private BaseballView baseballView;
    private Baseball baseball;

    public BaseballController(BaseballView baseballView, Baseball baseball) {
        this.baseballView = new BaseballView();
        this.baseball = new Baseball();
    }

    public void startGame() {
        List<Integer> list;
        do {
            baseballView.printGame();
            baseball.setUserNumber(Console.readLine());
            list = baseball.estimateScore();
            baseballView.printHint(list);
        } while (list.get(1) == 3);
    }
}
