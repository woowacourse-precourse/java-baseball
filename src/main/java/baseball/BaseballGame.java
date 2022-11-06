package baseball;

import baseball.domain.Computer;
import baseball.domain.Referee;
import baseball.domain.GameResult;
import baseball.domain.User;
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
        computer.generateAnswer();
    }

    private void start() {
        int strikeCount;

        do {
            user.enterNumber();
            GameResult gameResult = referee.judge(computer.getAnswer(), user.getInputNumber());
            strikeCount = gameResult.getStrikeCount();
            gameResult.show();
        } while (strikeCount != GAME_END_STRIKE_COUNT);
    }

    private void end() {
        Message.showGameEndMessage();
    }
}
