package baseball.validator;

import static baseball.constant.GameConstant.RESTART;
import static baseball.constant.GameConstant.END_GAME;

public class RestartNumberValidator {

    public static void checkValidationRestartNumber(String restartNumber){
        if (!restartNumber.equals(RESTART) && !restartNumber.equals(END_GAME)) throw new IllegalArgumentException();
    }

    private RestartNumberValidator(){
    }
}
