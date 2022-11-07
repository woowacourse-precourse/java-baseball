package baseball;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController();

        boolean play = true;

        while (play) {
            gameController.start();
            play = gameController.askRestart();
        }
    }
}
