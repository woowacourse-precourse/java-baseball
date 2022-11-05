package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseBallGame baseBallGame = new BaseBallGame();
        User user = new User();

        baseBallGame.startGame();

        do {
            baseBallGame.userInput();
            baseBallGame.playGame();
            baseBallGame.restartOrStopMessage();

        } while (baseBallGame.restartOrStop(user.restartOrStopInput()) == 1);
    }
}

