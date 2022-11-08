package baseball;

import baseball.domain.Computer;
import baseball.domain.Game;
import baseball.domain.User;

public class Application {

    public static void main(String[] args) {
        Computer computer = new Computer();
        User user = new User();

        while (true) {
            Game game = new Game(computer, user);
            game.start();

            game.finish();

            if (game.isStop()) {
                break;
            }
        }
    }

}
