package baseball;

public class Application {
    public static void main(String[] args) {
        BaseBallGame baseBallGame = new BaseBallGame();
        baseBallGame.startGame();
        while (baseBallGame.isRepeat()) {
            baseBallGame.getInputValue();
            baseBallGame.checkResult();

            if (!baseBallGame.isRepeat()) {
                baseBallGame.checkRestartGame();
            }
        }
    }
}
