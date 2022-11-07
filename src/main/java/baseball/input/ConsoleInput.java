package baseball.input;

import baseball.exception.ExceptionMessage;
import basedomain.input.Input;
import camp.nextstep.edu.missionutils.Console;

public class ConsoleInput implements Input {

    @Override
    public int getInputInteger() {
        System.out.print(InputMessage.ASK_INPUT_INTEGER);
        String inputMessage = Console.readLine();

        try {
            return Integer.parseInt(inputMessage);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_INTEGER_FORMAT.toString());
        }
    }
}
