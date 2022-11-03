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
        //TODO: 플레이어가 입력한 숫자 기반 힌트 출력 구현
    }

    private static boolean isGameOver() {
        //TODO: 게임 종료 여부 반환하는 기능 구현 (3스트라이크일 때 종료)
        return false;
    }

    private static void gameOver() {
        //TODO: 게임 종료 구현
    }
}
