package baseball;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        baseballGame();
    }


    public static void baseballGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> answerNumbers = newAnswer();
        boolean guessResult;

        do {
            guessResult = tryGuess(answerNumbers);
        } while (!guessResult);

        boolean newGame = askNewGame();

        if (newGame) baseballGame();
        else return;
    }


    public static List<Integer> newAnswer() {
        List<Integer> answerNumber = new ArrayList<>();

        return answerNumber;
    }


    public static boolean tryGuess(List<Integer> answerNumber) {
        boolean result = false;

        return result;
    }


    public static List<Integer> checkBallCount(List<Integer> answerNumber, List<Integer> guessNumber) {
        List<Integer> ballCount = new ArrayList<>();

        return ballCount;
    }


    public static boolean checkStrike(int i, List<Integer> answerNumber, List<Integer> guessNumber) {
        boolean isStrike = false;

        return isStrike;
    }


    public static boolean checkBall(int targetNumber, List<Integer> answerNumber) {
        boolean isBall = false;

        return isBall;
    }


    public static List<Integer> userInput() {
        List<Integer> userGuess = new ArrayList<>();

        return userGuess;
    }


    public static List<Integer> guessStringToList(String userGuessString) {
        List<Integer> userGuess = new ArrayList<>();

        return userGuess;
    }


    public static boolean gameInputException(String userGuessString) {
        boolean error = false;

        return error;
    }


    public static boolean askNewGame() {
        boolean newGame = false;

        return newGame;
    }
}
