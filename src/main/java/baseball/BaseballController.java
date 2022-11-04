package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballController {
    private BaseballView baseballView;
    private Baseball baseball;

    public BaseballController(BaseballView baseballView, Baseball baseball) {
        this.baseballView = new BaseballView();
        this.baseball = new Baseball();
    }

    public void startGame() {

        do {
            baseballView.printGame();
            baseball.setUserNumber(Console.readLine());
        } while ();

    }
}
