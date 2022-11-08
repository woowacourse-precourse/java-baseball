package baseball.applications;

import baseball.domain.Computer;
import baseball.domain.Game;
import baseball.views.Input;
import baseball.views.Output;

public class GameService {
    private volatile static GameService INSTANCE;
    private static String computerNumber;
    private GameService() {
    }

    public static GameService getInstance() {
        if (INSTANCE == null) {
            synchronized (GameService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new GameService();
                }
            }
        }
        return INSTANCE;
    }

    public void startGame() {
        computerNumber = Computer.getRandomNumberString();
        Game game = new Game();

        playGame(game);
        restartGame(game);
    }

    private void restartGame(Game game) {
        if (game.resume(Input.askContinue())) {
            startGame();
        }
    }

    private void playGame(Game game) {
        String userNumber = Input.input();
        game.compare(userNumber, computerNumber);

        Output.result(game.getStrike(), game.getBall());
        endGame(game);
    }

    private void endGame(Game game) {
        if (game.checkEnd()) {
            playGame(game);
        }
    }

}
