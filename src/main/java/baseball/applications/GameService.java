package baseball.applications;

public class GameService {
    private volatile static GameService INSTANCE;
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
}
