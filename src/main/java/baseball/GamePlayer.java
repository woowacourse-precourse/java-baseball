package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GamePlayer {
    public static final int DIGIT_NUMBER = 3;
    public void play() {
        Target target = new Target();
        System.out.println(GameMessage.PLAY_BALL);
        boolean isGameOver = false;
        while (!isGameOver) {
            System.out.print(GameMessage.REQUEST_GUESS);
            BallCountGuess ballCountGuess = new BallCountGuess(Console.readLine());
            StrikeAndBallCount strikeAndBallCount = new StrikeAndBallCount(target.copy(), ballCountGuess);
            System.out.println(strikeAndBallCount);
            isGameOver = checkIsGameOver(strikeAndBallCount);
        }
    }

    private boolean checkIsGameOver(StrikeAndBallCount strikeAndBallCount) {
        if (strikeAndBallCount.isOut()) {
            System.out.println(GameMessage.GAME_CLEAR);
            return true;
        }
        return false;
    }
}
