package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Checker {
    static int strike = 0;
    static int ball = 0;
    static final int restart = 1;
    static final int finish = 2;

    private Checker() {

    }

    public static void getResult(List computerRandom, List userRandom) {

        if (computerRandom.equals(userRandom)) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            restartGame();
        } else {
            listNotEqual(computerRandom, userRandom);
            Application.getUserInput(computerRandom);
        }
    }


    public static void listNotEqual(List computerRandom, List userRandom) {
        for (int i = 0; i < computerRandom.size(); i++) {
            for (int j = 0; j < userRandom.size(); j++) {
                getBallStrike(computerRandom, userRandom, i, j);
            }
        }

        if (ball != 0) {
            System.out.printf("%s볼 ", ball);
        }
        if (strike != 0) {
            System.out.printf("%s스트라이크", strike);
        }
        if (ball == 0 && strike == 0) {
            System.out.print("낫싱");
        }

        System.out.println();

        // initialize
        strike = 0;
        ball = 0;
    }

    public static void getBallStrike(List computerRandom, List userRandom, int i, int j) {
        if (i == j && computerRandom.get(i) == userRandom.get(j)) {
            Checker.strike++;
        } else if (i != j && computerRandom.get(i) == userRandom.get(j)) {
            Checker.ball++;
        }
    }

    public static void validateUserAns(String userAns) {
        if (Integer.valueOf(userAns) != restart && Integer.valueOf(userAns) != finish) {
            throw new IllegalArgumentException();
        }
    }

    public static void restartGame() {
        String userAns = Console.readLine();
        validateUserAns(userAns);

        if (Integer.valueOf(userAns) == restart) {
            Application.startGame();
            // initialize
            strike = 0;
            ball = 0;
        }
    }
}
