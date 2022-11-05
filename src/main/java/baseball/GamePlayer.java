package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Set;

public class GamePlayer {
    private final BallGenerator ballGenerator = new BallGenerator();

    public void play() {
        Set<Integer> target = ballGenerator.generateRandom();
        System.out.println(GameMessage.PLAY_BALL);
        boolean isGameOver = false;
        while (!isGameOver) {
            System.out.print(GameMessage.REQUEST_GUESS);
            String input = Console.readLine();
            StrikeAndBallCount strikeAndBallCount = new StrikeAndBallCount(new ArrayList<>(target), ballGenerator.generateGuessValue(input));
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
