package baseball.controller;


import baseball.domain.Computer;
import baseball.service.BaseballGameService;
import java.util.List;
import baseball.view.BaseballGameView;

public class BaseballGameController {

    private Computer computer = new Computer();
    private BaseballGameService baseballGameService = new BaseballGameService();
    private BaseballGameView baseballGameView = new BaseballGameView();

    private final String RESTART = "1";
    private final int THREE_STRIKE = 3;


    public void run() {
        startGame();
        printEndGame();
        printRestartMessage();
        choiceRestartGame();
    }

    public void printStartGame() {
        baseballGameView.printStartGame();
    }

    public void printEndGame() {
        baseballGameView.printEndMessage();
    }

    public void printRestartMessage() {
        baseballGameView.printRestartMessage();
    }

    public void startGame() {
        baseballGameService.setComputerNumber();
        while (baseballGameService.getStrikeCount() != THREE_STRIKE) {
            baseballGameView.printInputNumber();
            updateHint(computer.getRandomNumber(), getUserNumber());
            printHint();
        }
    }

    private List<Integer> getUserNumber() {
        baseballGameService.setUserNumber();
        return baseballGameService.getUserNumber();
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
        if (baseballGameService.choiceRestartGame().equals(RESTART)) {
            baseballGameService.initStrikeCountAndBallCount();
            run();
        }
    }
}
