package baseball;

public class BaseballGame {

    public static void start() {
        Message.GAME_START.println();
        playGameUntilFinish();
    }

    private static void playGameUntilFinish() {
        while (true) {
            playGame();
            if (Input.readGameStatus() == GameStatus.GAME_OVER) {
                return;
            }
        }
    }

    private static void playGame() {
        BaseballGameNumber computerNumber = RandomNumberGenerator.generateBaseballGameNumber();
        guessNumberUntilCorrect(computerNumber);
        Message.GAME_OVER.println();
        Message.ASK_RESTART.println();
    }

    private static void guessNumberUntilCorrect(BaseballGameNumber computerNumber) {
        while (true) {
            BaseballGameNumber expectedNumber = guessNumber(computerNumber);
            if (BaseballGameNumber.isSame(computerNumber, expectedNumber)) {
                return;
            }
        }
    }

    private static BaseballGameNumber guessNumber(BaseballGameNumber computerNumber) {
        Message.INPUT_NUMBER.print();
        BaseballGameNumber expectedNumber = Input.readNumber();
        Hint.show(Counter.calculate(computerNumber, expectedNumber));
        return expectedNumber;
    }
}
