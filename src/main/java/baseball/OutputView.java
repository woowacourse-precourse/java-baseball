package baseball;

import java.util.Map;

public class OutputView {
    public static void printStartMessage() {
        System.out.println(MessageUtils.START_GAME_MESSAGE);
    }

    public static void printSwingResult(Map<Swing, Integer> swingResult) {
        // 스트라이크만 있는 경우
        if (swingResult.get(Swing.STRIKE) != 0 && swingResult.get(Swing.BALL) == 0) {
            System.out.println(swingResult.get(Swing.STRIKE) + MessageUtils.STRIKE_TEXT);
        }

        // 볼만 있는 경우
        else if (swingResult.get(Swing.STRIKE) == 0 && swingResult.get(Swing.BALL) != 0) {
            System.out.println(swingResult.get(Swing.BALL) + MessageUtils.BALL_TEXT);
        }

        // 스트라이크와 볼 모두 있는 경우
        else if (swingResult.get(Swing.STRIKE) != 0 && swingResult.get(Swing.BALL) != 0) {
            System.out.println(swingResult.get(Swing.BALL) + MessageUtils.BALL_TEXT + MessageUtils.BLANK_SPACE + swingResult.get(Swing.STRIKE) + MessageUtils.STRIKE_TEXT);
        }

        // 스트라이크와 볼 모두 없는 경우
        if (swingResult.get(Swing.STRIKE) == 0 && swingResult.get(Swing.BALL) == 0) {
            System.out.println(MessageUtils.NOTHING_TEXT);
        }
    }

    public static void printFinishMessage() {
        System.out.println(MessageUtils.FINISH_GAME_MESSAGE);
        System.out.println(MessageUtils.NEXT_GAME_MESSAGE);
    }
}