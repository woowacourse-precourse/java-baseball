package baseball;

import baseball.computer.Computer;
import baseball.counter.Counter;
import baseball.game.Game;
import baseball.game.Result;

public class Application {
    public static void main(String[] args) {
        Game game = new Game(new Result(), new Computer(), new Counter());
        game.start();
    }
}
