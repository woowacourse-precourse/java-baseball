package baseball.game;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class NumberBaseballGame {

    private static final List<Integer> answerNumberList = new ArrayList<>(), playerNumberList = new ArrayList<>();
    private static int ball, strike;
    private static boolean isPower = false;

    public static void powerOn() {
        if (!isPower) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            isPower = true;
        }
    }

    public static void start() {
        if (isPower) {
            setup();
            play();
            gameOver();
        }
    }

    public static void powerOff() {
        if (isPower) {
            answerNumberList.clear();
            playerNumberList.clear();
            ball = 0; strike = 0;
            isPower = false;
        }
    }

    protected static void setup() {
        pickAnswerNumberList();
    }

    protected static void pickAnswerNumberList() {
        answerNumberList.clear(); //이전 게임에서의 정답 삭제
        while (answerNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answerNumberList.contains(randomNumber)) {
                answerNumberList.add(randomNumber);
            }
        }
    }

    protected static void play() {
        do {
            inputPlayerNumberList();
            countBallAndStrike();
            printHint();
        } while(!isGameOver());
    }

    protected static void inputPlayerNumberList() {
        playerNumberList.clear();
        System.out.print("숫자를 입력해주세요 : ");

        String playerNumberStr = Console.readLine();
        if (isValidNumberStr(playerNumberStr)) {
            for (int i = 0; i < playerNumberStr.length(); i++) {
                int playerNumber = Integer.parseInt(playerNumberStr.substring(i, i + 1));
                playerNumberList.add(playerNumber);
            }
        }
        else throw new IllegalArgumentException(getNumberStrExceptionMessage(playerNumberStr));
    }

    private static boolean isValidNumberStr(String numberStr) {
        boolean isThreeDigit = numberStr.length() == 3,
                isOnlyNaturalNumber = numberStr.matches("[1-9]{3}"),
                isEachUniqueNumber = true;
        List<Character> eachNumberList = new ArrayList<>();

        for (int i = 0; i < numberStr.length(); i++) {
            char eachNumber = numberStr.charAt(i);
            if (eachNumberList.contains(eachNumber)) {
                isEachUniqueNumber = false;
            }
            eachNumberList.add(eachNumber);
        }
        return isThreeDigit && isOnlyNaturalNumber && isEachUniqueNumber;
    }

    private static String getNumberStrExceptionMessage(String numberStr) {
        if (numberStr.length() != 3) return "3자리 숫자를 입력해주세요.";
        else if (!numberStr.matches("[1-9]{3}")) return "1 ~ 9까지의 숫자만을 입력해주세요.";
        else return "각 자리의 숫자가 서로 다르도록 입력해주세요.";
    }

    protected static void countBallAndStrike() {
        ball = 0; strike = 0;
        for (int i = 0; i < playerNumberList.size(); i++) {
            int playerNumber = playerNumberList.get(i);
            if (isStrike(i)) strike++;
            else if (answerNumberList.contains(playerNumber)) ball++;
        }
    }

    private static boolean isStrike(int position) {
        return Objects.equals(answerNumberList.get(position), playerNumberList.get(position));
    }

    protected static void printHint() {
        String hint;
        if (ball == 0 && strike == 0) hint = "낫싱";
        else if (ball == 0) hint = strike + "스트라이크";
        else if (strike == 0) hint = ball + "볼";
        else hint = ball + "볼 " + strike + "스트라이크";
        System.out.println(hint);
    }

    protected static boolean isGameOver() {
        return strike == 3;
    }

    protected static void gameOver() {
        printGameOverPhrase();
    }

    protected static void printGameOverPhrase() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
    //========== Getter ==========

    protected static List<Integer> getAnswerNumberList() {
        return answerNumberList;
    }

    protected static List<Integer> getPlayerNumberList() {
        return playerNumberList;
    }

    protected static int getBall() {
        return ball;
    }

    protected static void setBall(int ball) {
        NumberBaseballGame.ball = ball;
    }

    protected static int getStrike() {
        return strike;
    }

    protected static void setStrike(int strike) {
        NumberBaseballGame.strike = strike;
    }

    protected static boolean getIsPower() {
        return isPower;
    }
}
