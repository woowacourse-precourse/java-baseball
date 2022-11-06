package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Checker {
    static int strike = 0;
    static int ball = 0;

    private Checker() {

    }

    public static void getResult(List computerList, List userList) {

        if (computerList.equals(userList)) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            restartGame();
        } else {
            listNotEqual(computerList, userList);
            Application.getUserInput(computerList);
        }
    }


    public static void listNotEqual(List computerList, List userList) {
        for (int i = 0; i < computerList.size(); i++) {
            for (int j = 0; j < userList.size(); j++) {
                getBallStrike(computerList, userList, i, j);
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

    public static void getBallStrike(List computerList, List userList, int i, int j) {
        if (i == j && computerList.get(i) == userList.get(j)) {
            Checker.strike++;
        } else if (i != j && computerList.get(i) == userList.get(j)) {
            Checker.ball++;
        }
    }

    public static void validateUserAns(String userAns) {
        if (Integer.valueOf(userAns) != 1 && Integer.valueOf(userAns) != 2) {
            throw new IllegalArgumentException();
        }
    }

    public static void restartGame() {
        String userAns = Console.readLine();
        validateUserAns(userAns);

        if (Integer.valueOf(userAns) == 1) {
            Application.startGame();
            // initialize
            strike = 0;
            ball = 0;
        }
    }
}
