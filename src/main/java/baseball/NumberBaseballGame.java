package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

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
        printGameStartPhrase();
        pickAnswerNumberList();
    }

    private static void printGameStartPhrase() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private static void pickAnswerNumberList() {
        answerNumberList.clear(); //이전 게임에서의 정답 삭제
        while (answerNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answerNumberList.contains(randomNumber)) {
                answerNumberList.add(randomNumber);
            }
        }
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
        for (int i = 0; i < playerNumberList.size(); i++) {
            int playerNumber = playerNumberList.get(i);
            if (!isStrike(i) && answerNumberList.contains(playerNumber)) ball++;
        }
    }

    private static void countStrike() {
        strike = 0;
        for (int i = 0; i < answerNumberList.size(); i++) {
            if (isStrike(i)) strike++;
        }
    }

    private static boolean isStrike(int position) {
        return Objects.equals(answerNumberList.get(position), playerNumberList.get(position));
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
        printGameOverPhrase();
    }

    private static void printGameOverPhrase() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
