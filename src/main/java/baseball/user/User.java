package baseball.user;

import baseball.constant.GameProcedureConstantString;
import baseball.input.Input;
import baseball.output.Print;
import baseball.validation.Validation;
import java.util.List;
import java.util.stream.Collectors;

public class User {
    public static List<Integer> createUserNonDuplicateIntegerList() {
        Print.printInline(GameProcedureConstantString.USER_SIDE_BASEBALL_CREATE_MESSAGE.getStringMessage());
        String userInput = Input.inputString();
        Validation.userBaseballInputValidation(userInput);
        return userInput.chars()
                .mapToObj(charDigit -> charDigit - '0')
                .collect(Collectors.toList());
    }

    public static boolean isGameFinish() {
        Print.printEndsWithEnter(GameProcedureConstantString.RETRY_GAME_OR_FINISH_GAME_MESSAGE.getStringMessage());
        String userInput = Input.inputString();
        Validation.gameFinishOrNotValidation(userInput);
        return true;
    }
}
