package baseball;

public class Application {
    public static void main(String[] args) {
        GameController gameController;
        do {
            gameController = new GameController();
            gameController.gameStart();
        } while (gameController.endProgram());
    }
}

