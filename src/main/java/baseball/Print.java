package baseball;

import java.util.HashMap;

public class Print {

    private static final String ROUND_START_MESSAGE = "숫자를 입력해주세요 : ";

    private static final String ROUND_RESULT_STRIKE_MESSAGE = "스트라이크 ";
    private static final String ROUND_RESULT_BALL_MESSAGE = "볼 ";
    private static final String ROUND_RESULT_NOTHING_MESSAGE = "낫싱";

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private static final String REPLAY_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void printRoundStart() {
        System.out.print(ROUND_START_MESSAGE);
    }

    public static void printRoundResult(Hints hints) {
        int strikeCount = hints.findHintCount(Hint.STRIKE);
        int ballCount = hints.findHintCount(Hint.BALL);
        int nothingCount = hints.findHintCount(Hint.NOTHING);

        if (ballCount > 0) {
            System.out.print(ballCount + ROUND_RESULT_BALL_MESSAGE);
        }
        if (strikeCount > 0) {
            System.out.print(strikeCount + ROUND_RESULT_STRIKE_MESSAGE);
        }
        if (nothingCount == 3) {
            System.out.print(ROUND_RESULT_NOTHING_MESSAGE);
        }
        System.out.println();
    }

    public static void printGameStart(){
        System.out.println(GAME_START_MESSAGE);
    }

    public static void printGameEnd(){
        System.out.println(GAME_END_MESSAGE);
    }

    public static void printReplayGame() {
        System.out.println(REPLAY_MESSAGE);
    }
}
