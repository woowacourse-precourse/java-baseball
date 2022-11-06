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

    public void run() {
        startGame();
        choiceRestartGame();
    }

    public void printStartGame() {
        baseballGameView.printStartGame();
    }

    public void startGame() {
        computer.setRandomNumber();
        List<Integer> computerRandomNumber = computer.getRandomNumber();

        while (baseballGameService.getStrikeCount() != THREE_STRIKE) {
            baseballGameView.printInputNumber();
            List<Integer> userNumber = getUserNumber();
            updateHint(computerRandomNumber, userNumber);
            printHint();
        }

        baseballGameView.printEndMessage();
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

    private void printHint() {
        baseballGameView.printBallCount(baseballGameService.getBallCount());
        baseballGameView.printStrikeCount(baseballGameService.getStrikeCount());
        baseballGameView.printNotThing(baseballGameService.getStrikeCount(), baseballGameService.getBallCount());
    }

    public void choiceRestartGame() {
        baseballGameView.printRestartMessage();
        if (baseballGameService.choiceRestartGame().equals(RESTART)) {
            baseballGameService.initStrikeCountAndBallCount();
            run();
        }
    }
}
