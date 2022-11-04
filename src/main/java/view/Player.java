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

            System.out.print(GameConstant.INPUT_PHRASE);
            input = scanner.nextLine();

            try {
                BaseballException.InputLengthException(input);
                BaseballException.InputTypeBoundaryException(input);
                BaseballException.InputRepeatException(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
            return input;
        }
}
