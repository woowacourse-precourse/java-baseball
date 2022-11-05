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
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> randomNumber = computerService.getRandomNumber();

        List<Integer> inputNumber = gameStartView.getInputNumbers();
        BallCountDto ballCountDto = computerService.compareNumber(inputNumber, randomNumber);

        gameResultView.showScore(ballCountDto);
    }
}
