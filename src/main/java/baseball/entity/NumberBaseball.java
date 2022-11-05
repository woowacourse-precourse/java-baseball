package baseball.entity;

import baseball.service.GameService;

public class NumberBaseball implements Game {

    public static final int GAME_ANSWER_MAX_VALUE = 3;

    private GameService gameService;

    public NumberBaseball() {
        this.gameService = new GameService(GAME_ANSWER_MAX_VALUE);
    }

    @Override
    public void run() {
        boolean flag = false;
        gameService.initGame();
        do {
            flag = gameService.startGame();
            gameService = new GameService(GAME_ANSWER_MAX_VALUE);
        } while (flag);
    }

}
