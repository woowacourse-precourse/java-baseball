package baseball.utils;

import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Exception {

    //regex for 1~9  3 digits
    public static final Pattern NUMBER_PATTERN = Pattern.compile("([0-9]{1,3})$");

    // change to regex
    public void checkInputNumbers(List<Integer> inputNumberList) {
        checkNumbersLength(inputNumberList);
        checkDuplicated(inputNumberList);
        checkInputZero(inputNumberList);
    }

    public void checkOneDigitNumber(int inputNumber) {
        if (!((inputNumber == Constant.PLAYER_RESTART)||(inputNumber == Constant.PLAYER_ENDGAME))) {
            throw new NumberFormatException("잘못된 입력의 숫자입니다");
        }
    }

    public static void checkCharDetect(String inputNumber) {
        if (!(inputNumber.charAt(0) >= 49) || !(inputNumber.charAt(0) <= 58)) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkNumbersLength(List<Integer> playerNumber) {
        if (!(playerNumber.size() == 3)) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkDuplicated(List<Integer> playerNumber) {
        Set<Integer> items = new HashSet<>();
        playerNumber.stream()
                .filter(n -> !items.add(n))
                .collect(Collectors.toSet());
        if (items.size() != 3) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkInputZero(List<Integer> playerNumber) {
        if (playerNumber.contains(0)) {
            throw new IllegalArgumentException();
        }
    }
}

