package view;

import constant.GameConstant;

import java.util.Scanner;

public class Player {

        public static void startPhrase() {
            System.out.println(GameConstant.GAME_START_PHRASE);
        }

        public static String numberInput() {
            Scanner scanner = new Scanner(System.in);
            return scanner.nextLine();
        }
}
