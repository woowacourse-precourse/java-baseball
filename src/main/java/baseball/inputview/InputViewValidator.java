package baseball.inputview;

import java.util.Arrays;

public class InputViewValidator {
    public static final int DEMAND_SIZE = 3;

    public static boolean validateSize(int number) {
        return String.valueOf(number).length() == DEMAND_SIZE;
    }

    public static boolean validateDifferenceNumber(int number) {
        String s = String.valueOf(number);
        int n = (int) Arrays.stream(String.valueOf(number).split(""))
                .distinct().count();
        return s.length() == n;
    }
}
