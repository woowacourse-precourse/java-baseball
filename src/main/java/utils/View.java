package utils;

import static utils.Constant.*;

public class View {
    public static void printIntro(){
        System.out.println(INTRO_MESSAGE);
    }

    public static void printInput(){
        System.out.print(INPUT_MESSAGE);
    }

    public static void printHint(int ball, int strike){
        if (strike == 0 && ball == 0) {
            System.out.println(HINT_NOTHING);
        } else if (strike == 0) {
            System.out.println(ball + HINT_BALL);
        } else if (ball == 0) {
            System.out.println(strike + HINT_STRIKE);
        } else {
            System.out.println(ball + HINT_BALL + " " + strike + HINT_STRIKE);
        }
    }

    public static void printGameEnd(){
        System.out.println(GAME_END_MESSAGE);
    }

    public static void printQuestionNewGame(){
        System.out.println(QUESTION_NEW_GAME_MESSAGE);
    }
}
