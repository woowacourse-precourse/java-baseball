package baseball.controller;


import baseball.domain.Computer;
import baseball.domain.User;
import baseball.service.BaseballGameService;
import java.util.List;
import baseball.view.BaseballGameView;

public class BaseballGameController {

    private Computer computer = new Computer();
    private BaseballGameService baseballGameService = new BaseballGameService();
    private BaseballGameView baseballGameView = new BaseballGameView();

    private final String RESTART = "1";
    private final int THREE_STRIKE = 3;

    private User user;


    public void startGame() {
        computer.setRandomNumber();
        List<Integer> computerRandomNumber = computer.getRandomNumber();

    }

    private List<Integer> getUserNumber() {
        user = new User();
        user.setSelectNumber();
        return user.getSelectNumber();
    }

    private void updateHint(List<Integer> computerRandomNumber, List<Integer> userNumber) {
        baseballGameService.updateStrikeCount(computerRandomNumber, userNumber);
        baseballGameService.updateBallCount(computerRandomNumber, userNumber);

    }
}
