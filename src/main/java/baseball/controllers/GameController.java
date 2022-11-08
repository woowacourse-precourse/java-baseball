package baseball.controllers;

public class GameController {
    private volatile static GameController INSTANCE;

    private GameController() {
    }

    public static synchronized GameController getInstance() {
        if (INSTANCE == null) {
            synchronized (GameController.class) {
                if (INSTANCE == null) {
                    INSTANCE = new GameController();
                }
            }
        }
        return INSTANCE;
    }
}
