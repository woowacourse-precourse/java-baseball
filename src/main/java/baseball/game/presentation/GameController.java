package baseball.game.presentation;

import baseball.game.application.GameService;

public class GameController {
    private static final GameController instance=new GameController();
    private final GameService gameService;
    private GameController() {
        this.gameService = GameService.getInstance();
    }
    public static GameController getInstance(){
        return instance;
    }
    public void run(){
        gameService.setGame();
        gameService.playGame();
    }
}
