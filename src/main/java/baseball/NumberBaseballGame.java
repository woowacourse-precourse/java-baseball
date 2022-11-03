package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class NumberBaseballGame {

    private static List<Integer> answerNumberList = new ArrayList<>(), playerNumberList = new ArrayList<>();
    private static int ball, strike;

    public static void start() {
        setup();
        play();
        gameOver();
    }

    private static void setup() {
        //TODO: 게임 준비 구현
    }

    private static void play() {
        do {
            inputPlayerNumberList();
            countBall();
            countStrike();
            printHint();
        } while(!isGameOver());
    }

    private static void inputPlayerNumberList() {
        playerNumberList.clear();
        System.out.print("숫자를 입력해주세요 : ");

        String playerNumberStr = Console.readLine();
        if (isValidNumberStr(playerNumberStr)) {
            for (int i = 0; i < playerNumberStr.length(); i++) {
                int playerNumber = Integer.parseInt(playerNumberStr.substring(i, i + 1));
                playerNumberList.add(playerNumber);
            }
        }
        else throw new IllegalArgumentException("유효한 숫자를 입력해주세요.");
    }

    private static boolean isValidNumberStr(String numberStr) {
        boolean isThreeDigit = numberStr.length() == 3,
                isOnlyNumber = !numberStr.matches("[a-zA-Z]"),
                isEachUniqueNumber = true;
        List<Character> eachNumberList = new ArrayList<>();

        for (int i = 0; i < numberStr.length(); i++) {
            char eachNumber = numberStr.charAt(i);
            if (eachNumberList.contains(eachNumber)) {
                isEachUniqueNumber = false;
            }
            eachNumberList.add(eachNumber);
        }
        return isThreeDigit && isOnlyNumber && isEachUniqueNumber;
    }

    private static void countBall() {
        ball = 0;
        for (Integer playerNumber : playerNumberList) {
            if (answerNumberList.contains(playerNumber)) ball++;
        }
    }

    private static void countStrike() {
        strike = 0;
        for (int i = 0; i < answerNumberList.size(); i++) {
            if (Objects.equals(answerNumberList.get(i), playerNumberList.get(i))) strike++;
        }
    }

    private static void printHint() {
        String hint;
        if (ball == 0 && strike == 0) hint = "낫싱";
        else if (ball == 0) hint = strike + "스트라이크";
        else if (strike == 0) hint = ball + "볼";
        else hint = ball + "볼 " + strike + "스트라이크";
        System.out.println(hint);
    }

    private static boolean isGameOver() {
        return strike == 3;
    }

    private static void gameOver() {
        //TODO: 게임 종료 구현
    }
}
