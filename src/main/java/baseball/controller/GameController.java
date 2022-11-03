package baseball.controller;

import baseball.dto.BallCountDto;
import baseball.service.ComputerService;
import baseball.view.GameStartView;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class GameController {

    private final ComputerService computerService;
    private final GameStartView gameStartView;

    public GameController() {
        computerService = new ComputerService();
        gameStartView = new GameStartView();
    }

    public void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> inputNumber = gameStartView.inputNumbers();
        BallCountDto ballCountDto = computerService.compareNumber(inputNumber);
    }
}
