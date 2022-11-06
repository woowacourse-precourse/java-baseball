package baseball;

import baseball.view.Message;

import static baseball.constant.Const.GAME_END_STRIKE_COUNT;

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
        do {
            init();
            start();
            end();
        } while (user.hasRetryIntention());
    }

    private void init() {
        referee.initCount();
        computer.generateAnswer();
    }

    private void start() {
        do {
            user.enterNumber();
            referee.judge(computer.getAnswer(), user.getInputNumber());
            referee.showResult();
        } while (referee.getStrikeCount() != GAME_END_STRIKE_COUNT);
    }

    private void end() {
        Message.showGameEndMessage();
    }
}
