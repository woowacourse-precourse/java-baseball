package baseball;

public class Application {
    public static void main(String[] args) {
        System.out.println(BaseballGame.GAME_START);
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.gameStart();
    }
}