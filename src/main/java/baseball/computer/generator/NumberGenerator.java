package baseball.computer.generator;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    private static boolean numberSetting = false;
    private static List<Integer> testNumber = new ArrayList<>();

    public static List<Integer> getNumber() {
        if (numberSetting) {
            numberSetting = false;
            return testNumber;
        }
        return RandomNumberGenerator.generateRandomNumber();
    }

    public static void setTestNumber(List<Integer> number) {
        numberSetting = true;
        testNumber = number;
    }
}
