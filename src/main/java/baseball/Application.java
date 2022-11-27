package baseball;

import baseball.domain.*;
import baseball.generator.BaseBallNumberGenerator;

public class Application {
    public static void main(String[] args) {
        Game game = new Game(new Referee(new Computer(new BaseBallNumberGenerator(), new Compare())));
        Player player = new Player();

        boolean isPass = game.start(player);
        while (!isPass) {
            isPass = game.isRestartOrEnd(isPass);
        }
    }
}
