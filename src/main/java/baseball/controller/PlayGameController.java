package baseball.controller;

import baseball.service.GameService;

public class PlayGameController {
    public static void run(){
        GameService.startOrder();
        GameService.inputOrder();
    }
}