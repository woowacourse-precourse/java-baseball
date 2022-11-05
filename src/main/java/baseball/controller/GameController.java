package baseball.controller;

import baseball.dto.BallCountDto;
import baseball.service.ComputerService;
import baseball.service.ValidateService;
import baseball.view.GameResultView;
import baseball.view.GameStartView;

import java.util.List;

public class GameController {

    public static final int MAX_STRIKE_SIZE = 3;
    public static final int RESTART_NUM = 1;
    private int restartGameNum;

    private final ComputerService computerService;
    private final GameStartView gameStartView;
    private final GameResultView gameResultView;
    private final ValidateService validateService;

    public GameController() {
        this.computerService = new ComputerService();
        this.gameStartView = new GameStartView();
        this.gameResultView = new GameResultView();
        this.validateService = new ValidateService();
    }

    public void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> randomNumber = makeRandomNumber();

        do {
            List<Integer> inputNumber = gameStartView.getInputNumbers();
            BallCountDto ballCountDto = computerService.compareNumber(inputNumber, randomNumber);
            gameResultView.showScore(ballCountDto);

            if (ballCountDto.getStrike() == MAX_STRIKE_SIZE) {
                restartGameNum = validateInputNumber(getReadLine());
                randomNumber = getIntegers(restartGameNum, randomNumber);
            }
        } while (restartGameNum == RESTART_NUM);
    }

    private List<Integer> makeRandomNumber() {
        return computerService.getRandomNumber();
    }

    private List<Integer> getIntegers(int restartGameNum, List<Integer> randomNumber) {
        if (restartGameNum == 1) {
            randomNumber = makeRandomNumber();
        }
        return randomNumber;
    }

    private int validateInputNumber(int readLine) {
        return validateService.validateInputNumber(readLine);
    }

    private int getReadLine() {
        return gameResultView.checkRestartGame();
    }
}
