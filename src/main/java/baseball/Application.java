package baseball;

public class Application {

    public static void main(String[] args) throws IllegalArgumentException {
        BaseBallGame baseballGame = BaseBallGame.getDevice();

        baseballGame.gameStart();
        baseballGame.gamePlaying();

    }
}