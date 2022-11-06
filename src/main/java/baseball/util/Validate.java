package baseball.util;

public class Validate {

    public static boolean isRuleDigit(String input) {
        return input.length() == GameRule.NUMBER_OF_NUMBERS;
    }

}
