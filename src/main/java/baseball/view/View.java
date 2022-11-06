package baseball.view;

import baseball.status.GameStatus;

public class View {

    public static void printRestartOrStop(){
        System.out.println(GameStatus.RESTART_OR_STOP_GAME.getText());
    }
    public static void printStartGame() {
        System.out.println(GameStatus.START_GAME.getText());
    }
    public static void printFinishGame() {
        System.out.println(GameStatus.END_GAME.getText());
    }

    public static void printInputUserNumber() {
        System.out.print(GameStatus.INPUT_USER_NUMBER.getText());
    }

    public static void printHint(String hint) {
        System.out.println(hint);
    }

    public static void printCompleteGame(){
        System.out.println(GameStatus.COMPLETE_GAME.getText());
    }



}
