package constant;

import static constant.Const.*;

public class Message {

    public static void showNumberRequestMessage() {
        System.out.print(NUMBER_INPUT_REQUEST_MESSAGE);
    }

    public static void showGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void showGameEndMessage() {
        System.out.println(GAME_END_MESSAGE);
    }

    public static void showRetryRequestMessage() {
        System.out.println(RESTART_REQUEST_MESSAGE);
    }

    public static void showGameResultMessage(int strikeCount, int ballCount) {
        if (strikeCount > 0 && ballCount > 0) {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        }

        if (strikeCount > 0 && ballCount == 0) {
            System.out.println(strikeCount + "스트라이크");
        }

        if (strikeCount == 0 && ballCount > 0) {
            System.out.println(ballCount + "볼");
        }

        if (strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
        }
    }
}
