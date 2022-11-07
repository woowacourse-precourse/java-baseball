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

    public void winGame() {
        baseBall.winGame();
    }

    public void userInputSave(String userNumber) {
        user.setUserNumber(userNumber);
    }

    public void saveResult() {
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

        if (strike == 3) {
            winGame();
        }
    }

    public void resetGame() {
        baseBall.resetGame();
    }

    public int getBall() {
        return baseBall.getBall();
    }

    public boolean isWinGame() {
        return baseBall.isWin();
    }

    public int getStrike() {
        return baseBall.getStrike();
    }

    public boolean isNotting() {
        return baseBall.isNotting();
    }

    // 테스트를 위한 컴퓨터 숫자 수정 메서드
    public void setComputerNumberList(List<Integer> computerNumberList) {
        computer.setComputerNumberList(computerNumberList);
    }

}
