package baseball.view;

import baseball.domain.Hint;
import baseball.domain.Score;

public class Output {

    private static final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String END_GAME_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static StringBuilder stringBuilder;

    public static void printStartGameMessage() {
        System.out.println(START_GAME_MESSAGE);
    }

    public static void printHint(Hint hint) {
        stringBuilder = new StringBuilder();
        int strike = hint.getScorePoint(Score.STRIKE);
        int ball = hint.getScorePoint(Score.BALL);
        if (strike == 0 && ball == 0) {
            stringBuilder.append(Score.NOTHING.getValue());
        } else if (strike != 0 && ball == 0) {
            stringBuilder.append(strike + Score.STRIKE.getValue());
        } else if (strike == 0 && ball != 0) {
            stringBuilder.append(ball + Score.BALL.getValue());
        } else if (strike != 0 && ball != 0) {
            stringBuilder.append(ball + Score.BALL.getValue())
                         .append(" ")
                         .append(strike + Score.STRIKE.getValue());
        }
        System.out.println(stringBuilder);
    }

    public static void printEndMessage() {
        System.out.println(END_GAME_MESSAGE);
    }

}
