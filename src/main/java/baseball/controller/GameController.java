package baseball.controller;

import baseball.service.GameService;
import camp.nextstep.edu.missionutils.Console;

public class GameController {
    private GameService gameService = new GameService();

    public void run() {
        start();
    }

    private void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        gameService.start();
    }
}
