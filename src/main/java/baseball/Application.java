package baseball;


import baseball.domain.Game;
import baseball.utils.RandomUtil;

public class Application {
    public static void main(String[] args) {
        Game game;
        do {
            game = new Game(RandomUtil.makeRandomComputerBalls());
        } while (game.isNotOver());
    }
}
