package baseball;

import abstracts.Game;

public class BaseballGame extends Game {

    BaseballGame() {
        this.gameName = "Baseball";
        this.status = Status.PLAYING;
        this.initialize();
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void terminate() {
    }
}
