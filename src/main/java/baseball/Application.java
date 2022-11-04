package baseball;


public class Application {
    public static void main(String[] args) {
        Game game;
        do {
            game = new Game(RandomUtil.makeRandomComputerBalls());
        } while (game.isNotOver());
    }
}
