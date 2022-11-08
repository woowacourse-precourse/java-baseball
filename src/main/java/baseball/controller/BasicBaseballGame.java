package baseball.controller;

import baseball.domain.Ball;
import baseball.view.Messenger;
import camp.nextstep.edu.missionutils.Console;

public class BasicBaseballGame implements GameStrategy {
    Messenger messenger;
    private static final int ZERO_STRIKE = 0;
    private static final int THREE_STRIKES = 3;

    public BasicBaseballGame() {
        this.messenger = new Messenger();
    }

    @Override
    public void runBaseballGame(Ball computerBall) {
        int strikeCount = ZERO_STRIKE;
        while (!isThreeStrike(strikeCount)) {
            Ball userBall = receiveUserBall();
            strikeCount = compareComputerBallWith(computerBall, userBall);
        }
        messenger.printAnswerMessage();
    }

    private boolean isThreeStrike(int strikeCount) {
        return strikeCount == THREE_STRIKES;
    }

    private Ball receiveUserBall() {
        messenger.printInputMessage();
        return new Ball(Console.readLine());
    }

    private int compareComputerBallWith(Ball computerBall, Ball userBall) {
        int strike = computerBall.compareByIndex(userBall);
        int ball = computerBall.compareByValue(userBall) - strike;
        messenger.printResultMessage(strike, ball);
        return strike;
    }
}
