package baseball.view;

import baseball.view.validation.InputValidation;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final InputValidation validation = new InputValidation();

    public static String readNumbers() {
        OutputView.printSelectNumber();
        String readLine = Console.readLine();
        validation.validDuplicateNumber(readLine);
        return readLine;
    }

    public static String readRestartOrEnd() {
        OutputView.printRestartAndEnd();
        String readLine = Console.readLine();
        validation.validStartOrEndNumber(readLine);
        return readLine;
    }
}
