package baseball;

import java.util.Scanner;
import java.util.ArrayList;

public class Application {
    private static final int midGame = 1;
    private static final int endGame = 2;
    private static int ball = 0;
    private static int strike = 0;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner scanner = new Scanner(System.in);
    }

    public static String getUserInput (Scanner scanner) {
        String userInput = scanner.nextLine();
        return userInput;
    }

    public static void announceBallAndStrike (int ball, int strike) {
        ArrayList<String> ballAndStrike = new ArrayList<>();
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

    public static void findBallAndStrike (String userInput, String answer) {
        for (int digit = 0; digit < 3; digit++) {
            char presentNumber = userInput.charAt(digit);
            int ballStrikeOrNot = answer.indexOf(presentNumber);
            if (ballStrikeOrNot == digit) {
                strike++;
                continue;
            }
            if (ballStrikeOrNot == -1) {
                continue;
            }
            ball+;
        }
    }
}
