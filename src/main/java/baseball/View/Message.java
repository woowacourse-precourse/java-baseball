package baseball.View;

import static baseball.View.Constant.*;

public class Message {
    public static void printStartMessage() {
        System.out.println(GAME_START);
    }

    public static void printGuessMessage() {
        System.out.println(GAME_GUESS);
    }

    public static void printSuccessMessage() {
        System.out.println(GAME_SUCCESS);
    }

    public static void printRetryMessage() {
        System.out.println(GAME_RETRY);
    }

    public static void printResultMessage(int strikeCount, int ballCount) {
        if(strikeCount != 0 && ballCount == 0) {
            System.out.println(strikeCount + "스트라이크");
        }
        else if(strikeCount == 0 && ballCount != 0) {
            System.out.println(ballCount + "볼");
        }
        else if(strikeCount != 0 && ballCount != 0) {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        }
        else {
            System.out.println("낫싱");
        }
    }
}
