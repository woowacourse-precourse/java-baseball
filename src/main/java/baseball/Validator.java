package baseball;

import java.util.List;
import java.util.Set;

import static baseball.Rule.*;

public class Validator {
    private static final int DIGITS = Rule.DIGITS.getValue();
    private static final int RANDOM_MIN = Rule.RANDOM_MIN.getValue();
    private static final int RANDOM_MAX = Rule.RANDOM_MAX.getValue();
    private static final String COMMAND_RESTART = Rule.COMMAND_RESTART.toString();
    private static final String COMMAND_END = Rule.COMMAND_END.toString();

    public static boolean isNumber(String input) {
        return input.chars()
                .allMatch(Character::isDigit);
    }

    public static boolean isValidNumber(List<Integer> playerNumber) {
        return isCorrectSize(playerNumber) &&
                isInRange(playerNumber) &&
                isNotDuplicated(playerNumber);
    }
    //i. 자릿수 체크
    public static boolean isCorrectSize(List<Integer> playerNumber) {
        return playerNumber.size() == DIGITS;
    }
    //ii. 숫자 범위 체크
    public static boolean isInRange(List<Integer> playerNumber) {
        return playerNumber.stream()
                .allMatch(v ->
                        RANDOM_MIN<= v && v <= RANDOM_MAX);
    }
    // iii. 숫자 중복 체크
    public static boolean isNotDuplicated(List<Integer> playerNumber) {
        return Set.copyOf(playerNumber).size() == DIGITS;
    }


    public static boolean isValidCommandNumber(String input) {
        return input.equals(COMMAND_RESTART) || input.trim().equals(COMMAND_END);
    }

}
