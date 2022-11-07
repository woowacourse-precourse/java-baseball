package baseball;

public class Application {
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame(new Hitter(), new Pitcher());
        baseballGame.playGame(true);
    }
}
