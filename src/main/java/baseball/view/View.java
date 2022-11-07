package baseball.view;

import static baseball.status.GameStatus.END_GAME;
import static baseball.status.GameStatus.START_GAME_MESSAGE;
import static baseball.status.GameStatus.RESTART_OR_STOP_GAME;
import static baseball.status.GameStatus.INPUT_USER_NUMBER;
import static baseball.status.GameStatus.COMPLETE_GAME;


public class View {

    public static void printRestartOrStop(){
        System.out.println(RESTART_OR_STOP_GAME.getText());
    }
    public static void printStartGame() {
        System.out.println(START_GAME_MESSAGE.getText());
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
