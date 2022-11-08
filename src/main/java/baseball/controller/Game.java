package baseball.controller;

import baseball.view.Console;
import baseball.view.View;

public class Game {
    View view = new Console();
    Round round = new Round();

    public void play() {
        view.initialStart();
    }
}
