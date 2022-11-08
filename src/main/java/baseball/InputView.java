package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String MESSAGE_COMMAND_INPUT_NUMBERS = "숫자를 입력해주세요 : ";

    public static String inputNumbers() {
        System.out.println(MESSAGE_COMMAND_INPUT_NUMBERS);
        String inputNumbers = Console.readLine();
        inputNumbers = removeBlank(inputNumbers);
        return inputNumbers;
    }

    private static String removeBlank(String input) {
        return input.replaceAll("\\s+", "");
    }
}