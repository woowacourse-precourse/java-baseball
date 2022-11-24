package View;

import Controller.validation;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String readLine() {
        String input = Console.readLine();

        validation.check_input(input);
        return input;

    }
}
