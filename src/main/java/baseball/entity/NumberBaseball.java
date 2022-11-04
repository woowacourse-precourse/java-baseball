package baseball.entity;

import baseball.service.GameService;

public class NumberBaseball implements Game{

    public static final int GAME_ANSWER_MAX_VALUE = 3;

    private GameService gameService;

    public NumberBaseball() {
        this.gameService = new GameService();
    }

    @Override
    public void start() {
        boolean flag = false;
        gameService.initGame();
        do {
            flag = gameService.startGame();
            gameService = new GameService();
        } while (flag);
    }

    @Override
    public void end() {
    }
}
