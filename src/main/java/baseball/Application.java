package baseball;

import baseball.player.Computer;
import baseball.player.User;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Play play = new Play(new User(new Validation()), new Computer(), new Hint());
        play.run();
    }
}
