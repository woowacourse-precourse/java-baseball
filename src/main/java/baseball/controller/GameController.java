package baseball.controller;

import baseball.dto.BallCountDto;
import baseball.service.ComputerService;
import baseball.view.GameResultView;
import baseball.view.GameStartView;

import java.util.List;

public class GameController {

    private final ComputerService computerService;
    private final GameStartView gameStartView;
    private final GameResultView gameResultView;

    public GameController() {
        computerService = new ComputerService();
        gameStartView = new GameStartView();
        gameResultView = new GameResultView();
    }

    public void gameStart() {
        int restartGameNum = 1;
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> randomNumber = computerService.getRandomNumber();

        do {
            List<Integer> inputNumber = gameStartView.getInputNumbers();
            BallCountDto ballCountDto = computerService.compareNumber(inputNumber, randomNumber);
            gameResultView.showScore(ballCountDto);

            if (ballCountDto.getStrike() == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                restartGameNum = gameResultView.checkRestartGame();
                if (restartGameNum == 1) {
                    randomNumber = computerService.getRandomNumber();
                }
            }

        } while (restartGameNum == 1);
    }
}
