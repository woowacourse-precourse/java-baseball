package baseball;

public class Application {
    public static void main(String[] args) {
        Game game = new Game(new Referee(), new Catcher(), new Pitcher(new Validator()));
        game.start();
    }
}
