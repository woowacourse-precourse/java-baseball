package baseball.service;

import baseball.model.BaseBall;
import baseball.model.Computer;
import baseball.model.User;

public class BaseBallService {
    private BaseBall baseBall = new BaseBall();
    private User user = new User();
    private Computer computer = new Computer();

    public void initGame() {
        computer.randomGenerate();
    }

    public boolean isWinGame() {
        return baseBall.isWin();
    }
}
