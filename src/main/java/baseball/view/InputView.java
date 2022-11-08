package baseball.view;


import baseball.domain.Constant;

public class InputView {
    public static void askUserInputNumber() {
        System.out.print(Constant.INPUT_USER_NUMBER_MESSAGE);
    }

    public static void askRestartGameMessage() {
        System.out.println(Constant.GAME_OPTION_MESSAGE);
    }

    public static void printFirstNumberBaseballGameMessage() {
        System.out.println(Constant.START_NUMBER_BASEBALL_MESSAGE);
        ;
    }


}
