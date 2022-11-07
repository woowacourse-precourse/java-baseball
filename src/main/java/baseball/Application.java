package baseball;

import baseball.domain.Computer;
import baseball.domain.Game;
import baseball.domain.User;

public class Application {
    public static void main(String[] args) {
        Computer computer = new Computer();
        User user = new User();

        Game game = new Game(computer, user);

        //1. 게임 시작 문구 출력
        game.startGame();

    }
}
