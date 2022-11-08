package baseball.service;

import baseball.domain.*;
import baseball.domain.Number;


public class GameService {

    private Balls computer;
    private final Number number;
    private boolean answer;

    public GameService(Number number) {
        this.number = number;
    }

    private void init() {
        computer = new Balls(number.getNumberList());
        this.answer = false;
    }

    public void startGame() {
        init();
    }

}
