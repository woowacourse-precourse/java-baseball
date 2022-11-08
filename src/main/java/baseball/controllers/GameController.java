package baseball.controllers;

import baseball.applications.GameService;
import baseball.views.Output;

public class GameController {
    private volatile static GameController INSTANCE;
    private final GameService gameService;

    private GameController() {
        Output.start();

        this.gameService = GameService.getInstance();
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
