package baseball;

import baseball.player.Computer;
import baseball.player.User;

public class Application {

    public static void main(String[] args) {
        User user = new User();
        Computer computer = new Computer();

        NumberBaseBallGame numberBaseBallGame = new NumberBaseBallGame(user, computer);
        numberBaseBallGame.play();
    }
}
