package baseball;

public class Application {
    public static void main(String[] args) {
        BaseBallGame baseBallGame = new BaseBallGame();
        baseBallGame.startGame();
        while (true) {
            baseBallGame.getInputValue();

            if (baseBallGame.isAnswer()) {
                break;
            }
        }
    }
}
