package baseball;

public class Application {
    public static void main(String[] args) {
        User user = new User();
        boolean restart = true;
        while (restart) {
            Game game = Game.start(user);
            game.run();
            restart = game.restart();
        }
    }
}
