package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        baseballGame();
    }


    public static void baseballGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> answerNumbers = newAnswer();
        String guessResult;

        do {
            guessResult = tryGuess(answerNumbers);
        } while (guessResult.equals("wrong"));

        if (guessResult.equals("error")) {
            return;
        }

        boolean newGame = askNewGame();

        if (newGame) baseballGame();
        else return;
    }


    public static List<Integer> newAnswer() {
        List<Integer> answerNumber = new ArrayList<>();

        while (answerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answerNumber.contains(randomNumber)) {
                answerNumber.add(randomNumber);
            }
        }

        return answerNumber;
    }


    public static String tryGuess(List<Integer> answerNumber) {
        String result = "wrong";

        List<Integer> userGuess = userInput();
        if (userGuess.isEmpty()) {
            return "error";
        }

        List<Integer> ballCount = checkBallCount(answerNumber, userGuess);

        int ball = ballCount.get(0), strike = ballCount.get(1);

        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        } else if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            result = "right";
        } else if (strike == 0) {
            System.out.println(ball + "볼");
        } else if (ball == 0) {
            System.out.println(strike + "스트라이크");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }

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
