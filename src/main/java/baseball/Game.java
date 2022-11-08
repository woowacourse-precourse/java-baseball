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
    private static final String GAMESTARTSTRING = "숫자 야구 게임을 시작합니다.";
    private static final String USERINPUTSTRING = "숫자를 입력해주세요 : ";
    private static final String BALLSTRING = "볼";
    private static final String STRIKESTRING = "스트라이크";
    private static final String NOTHINGSTRING = "낫싱";
    private static final String GAMECLEARSTRING = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String GAMEENDSTRING = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String SUCCESSSTRING = "3스트라이크";
    private static final String GAMECODEWRONGSTRING = "1과 2 중에 다시 입력해주세요.";
    private static int strike;
    private static int ball;

    public Game() {
    }

    public void startGame() {
        printStr(GAMESTARTSTRING);
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
            printStr(USERINPUTSTRING);
            userNumber = new RandomNumber();
            userNumber.checkUserInput();
            userNumberList = new ArrayList<>(userNumber.getRandomNumberList());

            resetCount();
            compareNumber();
            String compareResultStr = createCompareResultStr();
            printStr(compareResultStr);
            if (compareResultStr.equals(SUCCESSSTRING)) {
                printStr(GAMECLEARSTRING);
                break;
            }
        }
    }

    private static int endGame(int gameCode) {
        while (true) {
            printStr(GAMEENDSTRING);
            String codeStr = Console.readLine();
            if (checkGameCode(codeStr)) {
                gameCode = Integer.parseInt(codeStr);
                break;
            }
            printStr(GAMECODEWRONGSTRING);
        }
        return gameCode;
    }

    private static void compareNumber() {
        for (int i = 0; i < 3; i++) {
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
            resStr = NOTHINGSTRING;
            return resStr;
        }
        if (ball != 0) {
            resStr = ball + BALLSTRING + " ";
        }
        if (strike != 0) {
            resStr += strike + STRIKESTRING;
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
