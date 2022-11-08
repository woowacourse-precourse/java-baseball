package baseball.view;

import baseball.util.Validation;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static int getNumber() {
        String inputString =  Console.readLine();
        Validation.validateInput(inputString);

        return Integer.parseInt(inputString);
    }

    public static int isReplay() {
        OutputView.printReplayMessage();

        String inputString = Console.readLine();
        Validation.validateReplayInput(inputString);

        return Integer.parseInt(inputString);
    }
}
