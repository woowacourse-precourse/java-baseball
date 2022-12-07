package baseball.view;

import baseball.util.ConsoleMessage;
import baseball.util.Validator;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public List<Integer> readPlayerNumber() {
        printConsoleMessage(ConsoleMessage.INPUT_PLAYER_NUMBER.getMessage());
        String input = Validator.getValidatedPlayerNumber(Console.readLine());
        return convertToIntegerList(input);
    }

    private static List<Integer> convertToIntegerList(String input) {
        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public String readGameCommand() {
        printConsoleMessage(ConsoleMessage.INPUT_GAME_COMMAND.getMessage());
        return Console.readLine();
    }

    private void printConsoleMessage(String message) {
        System.out.println(message);
    }
}
