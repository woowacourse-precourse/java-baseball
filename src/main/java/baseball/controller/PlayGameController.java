package baseball.controller;

import baseball.service.GameService;
import baseball.service.NeedForGameService;

public class PlayGameController {
    public static void run(){
        NeedForGameService.startOrder();
        GameService.makeRandomBall();
        GameService.CatchException();
    }
}