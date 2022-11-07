package baseball;

public class BaseballGame {

    public static void start() {
        Message.GAME_START.println();
        playGameUntilFinish();
    }

    private static void playGameUntilFinish() {
        while (true) {
            BaseballGameNumber computerNumber = RandomNumberGenerator.generateBaseballGameNumber();
            guessNumberUntilCorrect(computerNumber);
            Message.GAME_OVER.println();
            Message.ASK_RESTART.println();
            if (Input.readGameStatus() == GameStatus.GAME_OVER) {
                return;
            }
        }
    }

    private static void guessNumberUntilCorrect(BaseballGameNumber computerNumber) {
        while (true) {
            Message.INPUT_NUMBER.print();
            BaseballGameNumber expectedNumber = Input.readNumber();
            Hint.show(Counter.calculate(computerNumber, expectedNumber));
            if (BaseballGameNumber.isSame(computerNumber, expectedNumber)) {
                return;
            }
        }
    }
}
