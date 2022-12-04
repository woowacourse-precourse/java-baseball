package baseball.view;

import baseball.util.GameStatus;
import baseball.util.InputExceptionPharse;
import baseball.util.PlayStatus;

public class InputException {
    public static void nullException(String userInput) throws IllegalArgumentException {
        if (userInput == null || userInput.isEmpty() || userInput.isBlank()) {
            throw new IllegalArgumentException(InputExceptionPharse.IS_NULL.getExceptionMsg());
        }
    }

    public static void notNumberSizeException(String msg) throws IllegalArgumentException{
        if (notNumberSize(msg, GameStatus.BALL_SIZE.getInitInfo())) {
            throw new IllegalArgumentException(InputExceptionPharse.NOT_BALL_SIZE.getExceptionMsg());
        }
    }

    public static void notGameNumberSizeException(String msg) throws IllegalArgumentException {
        if (notNumberSize(msg, GameStatus.GAME_STATUS_SIZE.getInitInfo())) {
            throw new IllegalArgumentException(InputExceptionPharse.NOT_PLAY_STATUS_SIZE.getExceptionMsg());
        }
    }

    private static boolean notNumberSize(String msg, int size) {
        if (msg.length() != size) {
            return true;
        }
        return false;
    }

    public static void notNumber(String msg) throws IllegalArgumentException{
        for (int msgIndex = 0; msgIndex < msg.length(); msgIndex++) {
            eachMsgIsNotNumber(msg.charAt(msgIndex));
        }
    }

    private static void eachMsgIsNotNumber(char eachMsg) {
        if (!Character.isDigit(eachMsg)) {
            throw new IllegalArgumentException(InputExceptionPharse.NOT_NUMBER.getExceptionMsg());
        }
    }

    public static void notGameStatusNumber(int msgNumber) throws IllegalArgumentException{
        if (!PlayStatus.isPlayStatusNumber(msgNumber)) {
            throw new IllegalArgumentException(InputExceptionPharse.NOT_PLAY_NUMBER.getExceptionMsg());
        }
    }
}
