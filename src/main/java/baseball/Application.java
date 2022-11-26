package baseball;

import baseball.domain.*;
import baseball.generator.BaseBallNumberGenerator;

public class Application {
    public static void main(String[] args) {
        Game game = new Game(new Computer(new BaseBallNumberGenerator()), new Player(), new Referee());

        boolean isPass = false;
        while (!isPass) {
            isPass = game.isRestartOrEnd(game.start());
        }
    }
}
