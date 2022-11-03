package baseball;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final int midGame = 1;
    private static final int endGame = 2;
    private static int ball = 0;
    private static int strike = 0;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> answerNumber = makeAnswerNumber();
    }

    public static String getUserInput () {
        return Console.readLine();
    }

    public static void announceBallAndStrike (int ball, int strike) {
        List<String> ballAndStrike = new ArrayList<>();
        if (ball > 0) {
            ballAndStrike.add(String.format("%d볼", ball));
        }
        if (strike > 0) {
            ballAndStrike.add(String.format("%d스트라이크", strike));
        }
        if (ballAndStrike.size() > 0) {
            System.out.println(String.join(",", ballAndStrike));
            return;
        }
        System.out.println("낫싱");
        return;
    }

    public static void announceBasedOnGameState (int gameState) {
        if (gameState == midGame) {
            System.out.print("숫자를 입력해주세요 : ");
        }
        if (gameState == endGame) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }
    }

    public static void findBallAndStrike (String userInput, List<Integer> answerNumber) {
        for (int digit = 0; digit < 3; digit++) {
            int presentNumber = userInput.charAt(digit) - 48;
            if (presentNumber == answerNumber.get(digit)) {
                strike++;
                continue;
            }
            if (answerNumber.contains(presentNumber)) {
                ball++;
            }
        }
    }

    public static List<Integer> makeAnswerNumber () {
        List<Integer> answerNumber = Randoms.pickUniqueNumbersInRange(1,9,3);
        return answerNumber;
    }
}
