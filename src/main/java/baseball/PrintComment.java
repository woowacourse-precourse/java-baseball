package baseball;

import static constant.Constant.*;

public class PrintComment {

    public static void printStartComment() {
        System.out.println(START_COMMENT);
    }

    public static void printInputComment() {
        System.out.print(INPUT_COMMENT);
    }

    public static void printUserInput(String numbers) {
        System.out.println(numbers);
    }

    public static void printGameState(GameState gameState) {
        if (gameState.getStrike()==ZERO && gameState.getBall()==ZERO) {
            System.out.println(NOTHING);
            return;
        }
        if (gameState.getBall()==ZERO) {
            System.out.println(gameState.getStrike()+STRIKE);
            return;
        }
        if (gameState.getStrike()==ZERO) {
            System.out.println(gameState.getBall()+BALL);
            return;
        }
        System.out.println(gameState.getBall()+BALL+" "+gameState.getStrike()+STRIKE);
    }

    public static void printCorrectComment() {
        System.out.println(CORRECT_COMMENT);
    }

    public static void printRestartComment() {
        System.out.println(RESTART_COMMENT);
    }
}