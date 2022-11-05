package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseBallGame baseBallGame = new BaseBallGame();

        baseBallGame.startGame();

        do {
            baseBallGame.playGame();
        } while (baseBallGame.restartOrStop() == 1);
    }
}

