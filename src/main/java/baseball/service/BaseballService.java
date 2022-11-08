package baseball.service;

import baseball.domain.Referee;
import baseball.domain.User;

import java.util.List;

public class BaseballService {

    private final Referee referee;
    private final User user;

    public BaseballService() {
        this.referee = new Referee();
        this.user = new User(referee);
    }

    public void initBaseballGame() {
        referee.generateRandomNumber();
    }

    public String playBaseballGame(List<Integer> userNumber) {
        user.inputUserNum(userNumber);
        user.compareNumber();
        String result = referee.returnResult();
        return result;
    }

    public boolean isGameClear() {
        return referee.isGameClear();
    }

}
