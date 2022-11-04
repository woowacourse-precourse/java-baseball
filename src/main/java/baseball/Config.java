package baseball;

public class Config {
    public static GameService gameService() {
        return new GameService(new InputBallNumber(), new RandomBallNumber());
    }
}
