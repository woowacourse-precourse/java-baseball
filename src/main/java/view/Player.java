package view;

import baseball.BaseballException;
import constant.GameConstant;

import java.util.Scanner;

public class Player {

        public static void startPhrase() {
            System.out.println(GameConstant.GAME_START_PHRASE);
        }

        public static String numberInput() {
            String input;
            Scanner scanner = new Scanner(System.in);

            System.out.print("숫자를 입력해주세요 : ");
            input = scanner.nextLine();

            try {
                BaseballException.InputLengthException(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
            return input;
        }
}
