package baseball;

import static constant.Const.GAME_END_STRIKE_COUNT;

public class BaseballGame {
    private Computer computer;
    private User user;
    private Referee referee;

    public BaseballGame() {
        this.computer = new Computer();
        this.user = new User();
        this.referee = new Referee();
    }

    public void run() {
        init();
        start();
    }

    private void init() {
        computer.setAnswer();
        referee.initCount();
    }

    private void start() {
        while (referee.getStrikeCount() != GAME_END_STRIKE_COUNT) {
            user.enterNumber();
            referee.judge(computer.getAnswer(), user.getInputNumber());
            referee.showResult();
        }
    }
}
