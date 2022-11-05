package baseball.user;

import baseball.constant.GameProcedureConstantString;
import baseball.input.Input;
import baseball.output.Print;
import baseball.validation.Validation;
import java.util.List;

public class User {
    public static List<Integer> createUserNonDuplicateIntegerList() {
        Print.printInline(GameProcedureConstantString.USER_SIDE_BASEBALL_CREATE_MESSAGE.getStringMessage());
        String userInput = Input.inputString();
        Validation.userBaseballInputValidation(userInput);
        return null;
    }
}
