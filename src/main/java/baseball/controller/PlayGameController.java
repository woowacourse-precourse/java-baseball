package baseball.controller;

import baseball.service.GameService;
public class PlayGameController {
    public void run(){
        GameService.startOrder();
        GameService.inputOrder();
    }
}