package baseball.play;

import baseball.output.Guide;

public class BaseBall {

    public void start() {
        Guide.printStartingGuide();
        Game game = new Game();
        game.start();
    }
}
