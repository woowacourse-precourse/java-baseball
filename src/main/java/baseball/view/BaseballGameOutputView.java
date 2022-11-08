package baseball.view;

import static baseball.view.BaseballGameConstant.START_GAME_MESSAGE;

import baseball.domain.BallCount;

public class BaseballGameOutputView {

    public static void gameStart() {
        System.out.println(START_GAME_MESSAGE);
    }

    public static void printBallCount(BallCount ballCount) {
        System.out.println(ballCount.toString());
    }
}
