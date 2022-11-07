package baseball.view;

import static baseball.status.GameStatus.*;

public class View {

    public static void printRestartOrStop(){
        System.out.println(RESTART_OR_STOP_GAME.getText());
    }
    public static void printStartGame() {
        System.out.println(START_GAME.getText());
    }
    public static void printFinishGame() {
        System.out.println(END_GAME.getText());
    }

    public static void printInputUserNumber() {
        System.out.print(INPUT_USER_NUMBER.getText());
    }

    public static void printHint(String hint) {
        System.out.println(hint);
    }

    public static void printCompleteGame(){
        System.out.println(COMPLETE_GAME.getText());
    }



}
