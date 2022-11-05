package baseball.controller;

import baseball.sevice.NumberBaseballService;
import baseball.view.NumberBaseballView;

public class NumberBaseballController {

    private final NumberBaseballService numberBaseballService = new NumberBaseballService();
    private final NumberBaseballView numberBaseballView = new NumberBaseballView();

    public void startGame() {
        numberBaseballService.initNumber();
        numberBaseballView.printStartGame();
    }

}
