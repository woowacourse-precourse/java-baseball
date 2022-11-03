package baseball.view;

import baseball.domain.Hint;

public class Output {

    private static final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String NOTHING = "낫씽";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String END_GAME_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String RESTART_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static StringBuilder stringBuilder;

    public static void printStartGameMessage() {
        System.out.println(START_GAME_MESSAGE);
    }

    public static void printHint(Hint hint) {
        stringBuilder = new StringBuilder();
     int strike=hint.getStrike();
     int ball = hint.getBall();
        if (strike == 0 && ball == 0) {
            stringBuilder.append(NOTHING);
        } else if (strike != 0 && ball == 0) {
            stringBuilder.append(strike + STRIKE);
        } else if (strike == 0 && ball != 0) {
            stringBuilder.append(ball + BALL);
        } else if (strike != 0 && ball != 0) {
            stringBuilder.append(ball + BALL).append(strike + STRIKE);
        }
        System.out.println(stringBuilder);
    }

    public static void printEndMessage() {
        System.out.println(END_GAME_MESSAGE);
        System.out.println(RESTART_GAME_MESSAGE);
    }
}
