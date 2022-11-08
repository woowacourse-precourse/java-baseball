package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    private static RandomNumber computerNumber;
    private static RandomNumber userNumber;
    private static List<Integer> computerNumberList;
    private static List<Integer> userNumberList;
    private static final String regex = "^[1-2]$";
    private static final String GAME_START_STRING = "숫자 야구 게임을 시작합니다.";
    private static final String USER_INPUT_STRING = "숫자를 입력해주세요 : ";
    private static final String BALL_STRING = "볼";
    private static final String STRIKE_STRING = "스트라이크";
    private static final String NOTHING_STRING = "낫싱";
    private static final String GAME_CLEAR_STRING = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String GAME_END_STRING = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String SUCCESS_STRING = "3스트라이크";
    private static final String GAME_CODE_WRONG_STRING = "1과 2 중에 다시 입력해주세요.";
    private static final int NUMBER_SIZE = 3;
    private static int strike;
    private static int ball;

    public Game() {
    }

    public void startGame() {
        printStr(GAME_START_STRING);
        int gameCode = 1;
        playGame(gameCode);
    }

    private static void printStr(String str) {
        System.out.println(str);
    }

    private static void playGame(int gameCode) {
        while (gameCode != 2) {
            computerNumber = new RandomNumber();
            computerNumber.createRandomNumber();
            computerNumberList = new ArrayList<>(computerNumber.getRandomNumberList());

            guessNumber();
            gameCode = endGame(gameCode);
        }
    }

    private static void guessNumber() {
        while (true) {
            printStr(USER_INPUT_STRING);
            userNumber = new RandomNumber();
            userNumber.createUserRandomNumber();
            userNumberList = new ArrayList<>(userNumber.getRandomNumberList());

            resetCount();
            compareNumber();
            String compareResultStr = createCompareResultStr();
            printStr(compareResultStr);
            if (compareResultStr.equals(SUCCESS_STRING)) {
                printStr(GAME_CLEAR_STRING);
                break;
            }
        }
    }

    private static int endGame(int gameCode) {
        while (true) {
            printStr(GAME_END_STRING);
            String codeStr = Console.readLine();
            if (checkGameCode(codeStr)) {
                gameCode = Integer.parseInt(codeStr);
                break;
            }
            printStr(GAME_CODE_WRONG_STRING);
        }
        return gameCode;
    }

    private static void compareNumber() {
        for (int i = 0; i < NUMBER_SIZE; i++) {
            int computerNum = computerNumberList.get(i);
            int userNum = userNumberList.get(i);

            if (computerNum == userNum) {
                strike++;
            } else if (computerNumberList.contains(userNum)) {
                ball++;
            }
        }
    }

    private static void resetCount() {
        strike = 0;
        ball = 0;
    }

    private static String createCompareResultStr() {
        String resStr = "";
        if (ball == 0 && strike == 0) {
            resStr = NOTHING_STRING;
            return resStr;
        }
        if (ball != 0) {
            resStr = ball + BALL_STRING + " ";
        }
        if (strike != 0) {
            resStr += strike + STRIKE_STRING;
        }

        return resStr;
    }

    private static boolean checkGameCode(String gameCodeStr) {
        if (gameCodeStr.matches(regex)) {
            return true;
        }
        return false;
    }
}
