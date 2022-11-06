package game.stdiogame.numberbaseball;

import game.Game;
import game.GameManager;
import game.GameStatus;

public class NumberBaseballStdIOGameManager implements GameManager {
    private final Game game;
    private static final NumberBaseballStdIOGameManager INSTANCE = new NumberBaseballStdIOGameManager();
    private NumberBaseballStdIOGameManager() {
        GameStatus gameStatus = new NumberBaseballStdIOGameStatus();
        game = new NumberBaseballStdIOGame("숫자 야구 게임", gameStatus);
    }

    public static NumberBaseballStdIOGameManager getInstance() {
        return INSTANCE;
    }

    @Override
    public void restartGame() {

    }

    @Override
    public void startGame() {
        game.start();
    }
}
