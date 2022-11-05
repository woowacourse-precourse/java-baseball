package baseball.view;

import baseball.vo.Score;

public class OutputView {
    private static final String GAME_START_STR = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_HINT_STR = "숫자를 입력해주세요 : ";
    private static final String GAME_END_STR = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_OR_EXIT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";

    public static void printGameStart() {
        System.out.println(GAME_START_STR);
    }

    public static void printResult(Score score) {
        String result = "";

        result += getBallStr(score.getBall());
        result += getBetweenStr(score);
        result += getStringStr(score.getStrike());
        result += getNothingStr(score);
        System.out.println(result);
    }

    private static String getNothingStr(Score score) {
        if (score.getStrike() == 0 && score.getBall() == 0) {
            return NOTHING;
        }
        return "";
    }

    private static String getStringStr(int strike) {
        if (strike > 0) {
            return strike + STRIKE;
        }
        return "";
    }


    private static String getBallStr(int ball) {
        if (ball > 0) {
            return ball + BALL;
        }
        return "";
    }

    private static String getBetweenStr(Score score) {
        if (score.getBall() > 0 && score.getStrike() > 0) {
            return " ";
        }
        return "";
    }

    public static void printGameEnd() {
        System.out.println(GAME_END_STR);
    }

    public static void printInputHint() {
        System.out.print(INPUT_HINT_STR);
    }

    public static void printRestartOrExit() {
        System.out.println(RESTART_OR_EXIT);
    }
}
