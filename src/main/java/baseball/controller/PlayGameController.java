package baseball.controller;

import baseball.service.GameService;
import baseball.view.OrderView;
public class PlayGameController {
    public void run(){
        OrderView.startOrder();
        OrderView.inputOrder();
    }
}