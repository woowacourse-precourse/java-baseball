package baseball;

import java.util.Map;

public class OutputView {
    private static final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다";
    private static final String FINISH_GAME_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String NEXT_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";
    private static final String STRIKE_TEXT = "스트라이크";
    private static final String BALL_TEXT = "볼";
    private static final String NOTHING_TEXT = "낫싱";
    private static final String BLANK_SPACE = " ";

    public static void printStartMessage() {
        System.out.println(START_GAME_MESSAGE);
    }

    public static void printSwingResult(Map<Swing, Integer> swingResult) {
        // 스트라이크만 있는 경우
        if (swingResult.get(Swing.STRIKE) != 0 && swingResult.get(Swing.BALL) == 0) {
            System.out.println(swingResult.get(Swing.STRIKE) + STRIKE_TEXT);
        }

        // 볼만 있는 경우
        else if (swingResult.get(Swing.STRIKE) == 0 && swingResult.get(Swing.BALL) != 0) {
            System.out.println(swingResult.get(Swing.BALL) + BALL_TEXT);
        }

        // 스트라이크와 볼 모두 있는 경우
        else if (swingResult.get(Swing.STRIKE) != 0 && swingResult.get(Swing.BALL) != 0) {
            System.out.println(swingResult.get(Swing.STRIKE) + STRIKE_TEXT + BLANK_SPACE + swingResult.get(Swing.BALL) + BALL_TEXT);
        }

        // 스트라이크와 볼 모두 없는 경우
        if (swingResult.get(Swing.STRIKE) == 0 && swingResult.get(Swing.BALL) == 0) {
            System.out.println(NOTHING_TEXT);
        }
    }

    public static void printFinishMessage() {
        System.out.println(FINISH_GAME_MESSAGE);
        System.out.println(NEXT_GAME_MESSAGE);
    }
}