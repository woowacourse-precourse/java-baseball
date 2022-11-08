package baseball.view;

import baseball.model.Game;

public class View {
    private static final String NOTHING_MESSAGE = "낫싱\n";
    private static final String STRIKE_MESSAGE_FORMAT = "%d스트라이크\n";
    private static final String BALL_MESSAGE_FORMAT = "%d볼\n";
    private static final String BALL_AND_STRIKE_MESSAGE_FORMAT = "%d볼 %d스트라이크\n";

    private static final String GAME_CLEAR_MESSAGE_FORMAT = "%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n";
    private static final String REPLAY_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";

    public void printNothing() {
        System.out.print(NOTHING_MESSAGE);
    }

    public void printBallAndStrike(int ballCount, int strikeCount) {
        System.out.printf(BALL_AND_STRIKE_MESSAGE_FORMAT, ballCount, strikeCount);
    }

    public void printStrike(int strikeCount) {
        System.out.printf(STRIKE_MESSAGE_FORMAT, strikeCount);
    }

    public void printBall(int ballCount) {
        System.out.printf(BALL_MESSAGE_FORMAT, ballCount);
    }


    public void printGameClear(int answerLength) {
        System.out.printf(GAME_CLEAR_MESSAGE_FORMAT, answerLength);
    }

    public void printReplay(){
        System.out.printf(REPLAY_MESSAGE);
    }
}
