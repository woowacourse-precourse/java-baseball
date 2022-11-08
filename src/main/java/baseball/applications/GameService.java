package baseball.applications;

import baseball.domain.Computer;
import baseball.domain.Game;

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
    }

}
