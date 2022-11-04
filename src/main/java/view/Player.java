package view;

import constant.GameConstant;

import camp.nextstep.edu.missionutils.Console;

public class Player {

    public static void startPhrase() {
        System.out.println(GameConstant.GAME_START_PHRASE);
    }

    public static String numberInput() {
        String input;

        System.out.print(GameConstant.INPUT_PHRASE);
        input = Console.readLine();

        return input;
    }

    public static void printHint(int ball, int strike) {
        if (ball != 0 && strike != 0) {
            System.out.println(ball + GameConstant.BALL + " " + strike + GameConstant.STRIKE);
        }

        if (ball != 0 && strike == 0) {
            System.out.println(ball + GameConstant.BALL);
        }

        if (ball == 0 && strike != 0) {
            System.out.println(strike + GameConstant.STRIKE);
        }

        if (ball == 0 && strike == 0) {
            System.out.println(GameConstant.NOTHING);
        }
    }

    public static void printEnd() {
        System.out.println(GameConstant.THREE_STRIKE);
        System.out.println(GameConstant.END_GAME);
        System.out.println(GameConstant.AGAIN);
    }

    public static boolean endGame() {
        String again;

        again = Console.readLine();

        return again.equals("1");
    }
}

