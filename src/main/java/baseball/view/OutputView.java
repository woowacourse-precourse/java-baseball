package baseball.view;

import baseball.constant.Constant;

public class OutputView {

    public static void printRestartOrEndGame() {

        System.out.println(Constant.SELECT_RESTART_OR_END_MESSAGE);
    }

    public static void printStartBaseballGame() {

        System.out.println(Constant.START_BASEBALL_NUMBER_GAME_MESSAGE);
    }

    public static void printHintMessage(String hintMessage) {

        System.out.println(hintMessage);
    }

    public static void printPlayerCorrectAnswerMessage() {

        System.out.println(Constant.PLAYER_CORRECT_ANSWER_NUMBER_MESSAGE);
    }

    public static void printEndBaseballGameMessage() {

        System.out.println(Constant.END_BASEBALL_GAME_MESSAGE);
    }
}
