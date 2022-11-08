package baseball.view.inputview;

import java.util.Arrays;

public class InputViewValidator {
    public static final int DEMAND_SIZE = 3;
    public static final String SEPARATOR = "";

    public static boolean validateSize(String userInputNumber) {
        return userInputNumber.length() == DEMAND_SIZE;
    }

    public static boolean validateDifferenceNumber(String userInputNumber) {
        return userInputNumber.length() == Arrays.stream(userInputNumber.split(SEPARATOR))
                .distinct().count();
    }
}
