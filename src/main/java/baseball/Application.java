package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        startGame();
    }

    public static void startGame() {

        showGameStart();

        do {
            List<Integer> randomNumberList = new ArrayList<>();
            putInRandomNumber(randomNumberList);
            playGame(randomNumberList);
            endGame();

        } while (replayGame());
    }

    public static void showGameStart() {

        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void playGame(List<Integer> randomNumberList) {

        while (true) {

            String numberString = putInNumber();

            checkUserNumber(numberString);

            int[] userNumbers = {0, 0, 0};
            addUserNumberInUserArray(userNumbers, numberString);

            int strike = countingStrike(0, userNumbers, randomNumberList);
            int ball = countingBall(0, userNumbers, randomNumberList);
            printCount(ball, strike);

            if (checkThreeStrike(strike)) {
                break;
            }

        }

    }

    public static void putInRandomNumber(List<Integer> randomNumberList) {

        while (randomNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!randomNumberList.contains(randomNumber)) {

                randomNumberList.add(randomNumber);
            }
        }
    }

    public static String putInNumber() {

        System.out.print("숫자를 입력해주세요 : ");

        return Console.readLine();
    }

    public static void checkUserNumber(String numberString) {

        try {

            if (!checkingUserNumberIsCorrect(numberString)) {

                throw new IllegalArgumentException();
            }

        } catch (IllegalArgumentException e) {

            throw new IllegalArgumentException();
        }

    }

    public static boolean checkingUserNumberIsCorrect(String numberString) {

        return checkUserNumberLength(numberString) && checkUserNumberIsInteger(numberString) && checkUserNumberIsDuplicate(numberString);
    }

    public static boolean checkUserNumberLength(String numberString) {

        return numberString.length() == 3;
    }

    public static boolean checkUserNumberIsInteger(String numberString) {

        for (int i = 0; i < numberString.length(); i++) {
            if (numberString.charAt(i) < 49 || numberString.charAt(i) > 57) {

                return false;
            }
        }

        return true;
    }

    public static boolean checkUserNumberIsDuplicate(String numberString) {

        return (int) numberString.charAt(0) != (int) numberString.charAt(1)
                && (int) numberString.charAt(1) != (int) numberString.charAt(2)
                && (int) numberString.charAt(0) != (int) numberString.charAt(2);

    }

    public static void addUserNumberInUserArray(int[] userNumbers, String numberString) {

        for (int i = 0; i < numberString.length(); i++) {
            userNumbers[i] = numberString.charAt(i) - 48;
        }

    }

    public static Integer countingStrike(int strike, int[] userNumbers, List<Integer> randomNumberList) {

        for (int i = 0; i < 3; i++) {
            if (userNumbers[i] == randomNumberList.get(i)) {

                strike += 1;
            }
        }

        return strike;
    }

    public static Integer countingBall(int ball, int[] userNumbers, List<Integer> randomNumberList) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ball = checkAndCountBall(ball, userNumbers[i], randomNumberList.get(j), i, j);
            }
        }

        return ball;
    }

    public static Integer checkAndCountBall(int ball, int userNumber, int randomNumber, int userIndex, int randomIndex) {

        if (userNumber == randomNumber && userIndex != randomIndex) {

            ball += 1;
        }

        return ball;
    }

    public static void printCount(int ball, int strike) {
        if (ball == 0 && strike == 0) {

            System.out.println("낫싱");
        }

        if (ball > 0 && strike == 0) {

            System.out.println(ball + "볼");
        }

        if (ball == 0 && strike > 0) {

            System.out.println(strike + "스트라이크");
        }

        if (ball > 0 && strike > 0) {

            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }

    public static boolean checkThreeStrike(int strike) {

        return strike == 3;
    }

    public static void endGame() {

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

    }

    public static boolean replayGame() {

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String replayNumberString = Console.readLine();

        checkReplayNumber(replayNumberString);

        return replayNumberString.charAt(0) - 48 == 1;
    }

    public static void checkReplayNumber(String replayNumberString) {

        try {

            if (!checkReplayNumberLength(replayNumberString) || !checkReplayNumberCount(replayNumberString)) {
                throw new IllegalArgumentException();
            }

        } catch (IllegalArgumentException e) {

            throw new IllegalArgumentException();
        }
    }

    public static boolean checkReplayNumberLength(String replayNumberString) {

        return replayNumberString.length() == 1;
    }

    public static boolean checkReplayNumberCount(String replayNumberString) {

        int replayNumber = replayNumberString.charAt(0) - 48;

        return replayNumber == 1 || replayNumber == 2;
    }
}
