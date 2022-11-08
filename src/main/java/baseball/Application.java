package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseBallGame baseBallGame = new BaseBallGame();
        User user = new User();

        baseBallGame.printStartGameMessage();

        do {
            baseBallGame.printUserInputMessage();
            baseBallGame.playGame();
            baseBallGame.printRestartOrStopMessage();

        } while (baseBallGame.restartOrStop(user.restartOrStopInput()) == 1);
    }
}

