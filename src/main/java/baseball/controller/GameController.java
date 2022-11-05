package baseball.controller;

import baseball.dto.BallCountDto;
import baseball.service.ComputerService;
import baseball.service.ValidateService;
import baseball.view.GameResultView;
import baseball.view.GameStartView;

import java.util.List;

public class GameController {

    private final ComputerService computerService;
    private final GameStartView gameStartView;
    private final GameResultView gameResultView;
    private final ValidateService validateService;
    private int restartGameNum = 1;

    public GameController() {
        this.computerService = new ComputerService();
        this.gameStartView = new GameStartView();
        this.gameResultView = new GameResultView();
        this.validateService = new ValidateService();
    }

    public void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> randomNumber = computerService.getRandomNumber();

        do {
            List<Integer> inputNumber = gameStartView.getInputNumbers();
            BallCountDto ballCountDto = computerService.compareNumber(inputNumber, randomNumber);
            gameResultView.showScore(ballCountDto);

            if (ballCountDto.getStrike() == 3) {
                restartGameNum = validateInputNumber(getReadLine());
                randomNumber = makeNewRandomNum(restartGameNum, randomNumber);
            }
        } while (restartGameNum == 1);
    }

    private List<Integer> makeNewRandomNum(int restartGameNum, List<Integer> randomNumber) {
        if (restartGameNum == 1) {
            randomNumber = computerService.getRandomNumber();
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
