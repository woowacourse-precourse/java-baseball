package baseball.ui;

import camp.nextstep.edu.missionutils.Console;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;

public class InputUtil {
    private InputUtil() {
    }

    public static String inputAnswer() {
        System.out.println("숫자를 입력해주세요 :");
        return Console.readLine();
    }

    public static String inputContinueGame() {
        String input = "";

        while (!isValidInputForContinueGame(input)) {
            System.out.println(
                    MessageFormat.format("게임을 새로 시작하려면 {0}, 종료하려면 {1}를 입력하세요.",
                            ShortCut.END_GAME.getValue(),
                            ShortCut.CONTINUE_GAME.getValue())
            );

            input = Console.readLine();
        }
        return input;
    }

    private static boolean isValidInputForContinueGame(String input) {
        List<String> validInputs = Arrays.asList(
                ShortCut.CONTINUE_GAME.getValue(),
                ShortCut.END_GAME.getValue()
        );

        return validInputs.contains(input);
    }


}
