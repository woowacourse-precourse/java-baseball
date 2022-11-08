package baseball.controller;

import baseball.service.GameService;
import baseball.service.NeedForGameService;

public class PlayGameController {
    public static void startGame() {
        NeedForGameService.callStartOrder();
        run();
    }

    public static void run() {
        GameService.makeRandomBall();
        GameService.catchRandomBall();
    }
}