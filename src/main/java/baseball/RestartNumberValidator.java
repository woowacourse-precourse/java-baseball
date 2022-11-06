package baseball;

public class RestartNumberValidator {

    public static void checkValidationRestartNumber(String restartNumber){
        if (!restartNumber.equals("1") && !restartNumber.equals("2"))
            throw new IllegalArgumentException();
    }
}
