package baseball.service;

import baseball.view.InputView;

public class Game {
    private static final int RESTART = 1;
    private static final int EXIT = 2;

    private Rule rule;

    public Game() {
        this.rule = new Rule();
    }

    public void run() {
        InputView.printStartMessage();
        init();
        process();
        reStrart();
    }

    private void init() {
        rule.generateRandomNumber();
    }

    private boolean process() {

    }

    private int reStrart() {

    }
}
