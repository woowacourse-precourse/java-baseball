package baseball;

public class Application {
    public static void main(String[] args) {
        boolean restart = true;
        while (restart) {
            User user = new User();
            Game game = Game.start(user);
            restart = game.run();
        }
    }
}
