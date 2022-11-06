package baseball;

public class Config {

    public static PlayGameController playGameController() {
        return new PlayGameController(new GameService(new InputBallNumber(), new RandomBallNumber()), new PrintGameResult());
    }
}
