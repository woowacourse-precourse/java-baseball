package baseball.view;

import static baseball.Constants.RESTART_OR_EXIT_TEXT;
import static baseball.Constants.USER_INPUT_TEXT;

import baseball.util.TypeConversion;
import baseball.util.Validator;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {

    public static List<Integer> roundInput() {
        System.out.print(USER_INPUT_TEXT);
        String userInput = Console.readLine();

        Validator.validateUserInputIsNullOrEmpty(userInput);
        Validator.validateUserInputIsThreeDigits(userInput);
        Validator.validateUserInputIsMinRangeToMaxRange(userInput);
        Validator.validateUserInputHasDuplicateNumber(userInput);

        return TypeConversion.stringToIntList(userInput);
    }

    public static int restartOrExitInput() {
        System.out.println(RESTART_OR_EXIT_TEXT);
        String userInput = Console.readLine();

        Validator.validateUserInputType(userInput);
        int userInputIntValue = TypeConversion.stringToInt(userInput);
        Validator.validateUserInputIsStartOrExit(userInputIntValue);

        return userInputIntValue;
    }
}
