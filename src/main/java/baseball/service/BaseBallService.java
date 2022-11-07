package baseball.service;

import baseball.model.BaseBall;
import baseball.model.Computer;
import baseball.model.User;

import java.util.List;

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

    public void winGame() {
        baseBall.winGame();
    }

    public void userInputSave(String userNumber) {
        user.setUserNumber(userNumber);
    }

    public void checkResult() {
        List<Integer> computerNumberList = computer.getComputerNumberList();
        List<Integer> userNumberList = user.getUserNumberList();

        int strike = 0, ball = 0;

        for (int i = 0; i < computerNumberList.size(); i++) {
            if (computerNumberList.get(i) == userNumberList.get(i)) {
                strike++;
            } else if (computerNumberList.contains(userNumberList.get(i))) {
                ball++;
            }
        }

        baseBall.setStrike(strike);
        baseBall.setBall(ball);
    }
}
