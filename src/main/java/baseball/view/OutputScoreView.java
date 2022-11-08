package baseball.view;

import baseball.vo.ScoreBoard;

public class OutputScoreView {
    public static final String BALL_MESSAGE = "볼";
    public static final String STRIKE_MESSAGE = "스트라이크";
    public static final String NONE_MESSAGE = "낫싱";

    public static void outputScoreBoard(ScoreBoard scoreBoard) {
        int strike = scoreBoard.getStrike();
        int ball = scoreBoard.getBall();

        StringBuilder totalMessage = new StringBuilder();
        totalMessage.append(getBallMessage(ball));
        totalMessage.append(getSpaceMessage(ball, strike));
        totalMessage.append(getStrikeMessage(strike));
        totalMessage.append(getNoneMessage(ball, strike));
        System.out.println(totalMessage);
    }

    private static String getNoneMessage(int ball, int strike) {
        String msg = "";
        if (!(ball == 0 && strike == 0))
            return msg;
        msg += NONE_MESSAGE;
        return msg;
    }

    private static String getStrikeMessage(int strike) {
        String msg = "";
        if (strike == 0)
            return msg;
        msg += strike;
        msg += STRIKE_MESSAGE;
        return msg;
    }

    private static String getSpaceMessage(int ball, int strike) {
        String msg = "";
        if (ball != 0)
            msg = " ";
        return msg;
    }

    private static String getBallMessage(int ball) {
        String msg = "";
        if (ball == 0) {
            return msg;
        }
        msg += ball;
        msg += BALL_MESSAGE;
        return msg;
    }
}
