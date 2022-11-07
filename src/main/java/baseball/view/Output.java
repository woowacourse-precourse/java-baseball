package baseball.view;

import baseball.domain.Number;

public class Output {
    private static final String STARTMESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String ENDMESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String WHITE_SPACE = " ";
    private static final String NOTHING = "낫싱";

    private Number number;

    public Output(Number number) {
        this.number = number;
    }

    public void printOutput() {
        StringBuffer result = new StringBuffer();
        if (number.isNothing()) {
            result.append(NOTHING);
        }
        int ball = number.getBall();
        int strike = number.getStrike();

        if (ball > 0) {
            result.append(ball).append(BALL).append(WHITE_SPACE);
        }
        if (strike > 0) {
            result.append(strike).append(STRIKE);
        }

        System.out.println(result);
    }

    public static void printStartMessage() {
        System.out.println(STARTMESSAGE);
    }

    public static void printEndMessage() {
        System.out.println(ENDMESSAGE);
    }
}
