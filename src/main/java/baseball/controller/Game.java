package baseball.controller;

import baseball.view.CLI;
import baseball.view.View;

public class Game {
    View view = new CLI();
    Round round = new Round();

    public void play() {
        view.initialStart();
        round.play(view);
    }
}
