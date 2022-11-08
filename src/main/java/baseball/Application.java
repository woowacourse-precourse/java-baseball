package baseball;

public class Application {
    public static void main(String[] args) {
        do {
            Game.playGame();
        } while (Game.restartGame());
    }

}
