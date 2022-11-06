package baseball;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseBallGame baseballGame = BaseBallGame.getGame();
        try {
            baseballGame.gameStart();
            baseballGame.gamePlaying();
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }
}