package baseball;

import camp.nextstep.edu.missionutils.Console;

public class View {

    private boolean validateUserResponse(String number) {
        if (number == null) {
            return false;
        }
        return number.matches("^[1-2]$");
    }

    private boolean validateUserInput(String number) {
        if (number == null) {
            return false;
        }
        return number.matches("^[1-9]{3}$");
    }
}
