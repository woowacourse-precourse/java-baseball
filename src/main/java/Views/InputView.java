package Views;

import static Utils.Exceptions.EXCEPTIONS;

public class InputView {
    public static final InputView INPUT_VIEW = new InputView();
    
    public String InputUserNumber(String readLine) {
        return EXCEPTIONS.ValidateUserInputNumber(readLine);
    }

}
