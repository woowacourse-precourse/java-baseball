package baseball.utils;

import baseball.model.Game;
import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    private static int numberOfDigit;
    private Game game;

    public UserInput(Game game, final int NUMBER_OF_DIGIT) {
        this.numberOfDigit = NUMBER_OF_DIGIT;
        this.game = game;
    }

    public void setUserInput() {
        String input = Console.readLine();
        validateNumber(input);
        validateNumberOfDigits(input);
        validateDuplicateNumber(input);

        int inputNumber = Integer.parseInt(input);
        game.setUserInputNumber(inputNumber);
    }

    public static int getNewGameStatusInput() {
        String input = Console.readLine();
        validateNumber(input);
        validateNewGameNumber(input);

        int newGameStatusNumber = Integer.parseInt(input);
        return newGameStatusNumber;
    }

    private static void validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
    }

    private static void validateNumberOfDigits(String input) {
        int inputNum = Integer.parseInt(input);
        int numberOfDigits = (int) (Math.log10(inputNum) + 1);

        if (numberOfDigits != numberOfDigit) {
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
        }
    }

    private static void validateDuplicateNumber(String input) {
        for (int i = 0; i < numberOfDigit; i++) {
            for (int j = i + 1; j < numberOfDigit; j++) {
                compareChar(input.charAt(i), input.charAt(j));
            }
        }
    }

    private static void compareChar(char ch1, char ch2) {
        if (ch1 == ch2) {
            throw new IllegalArgumentException("중복되지 않는 3자리 숫자를 입력해주세요.");
        }
    }

    private static void validateNewGameNumber(String input) {
        int inputNum = Integer.parseInt(input);
        if (inputNum != 1 && inputNum != 2) {
            throw new IllegalArgumentException("1 또는 2중에서 입력해주세요.");
        }
    }
}
