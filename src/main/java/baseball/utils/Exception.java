package baseball.utils;

import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Exception {
    // change to regex
    public static void checkInputNumbers(List<Integer> inputNumberList) {
        checkNumbersLength(inputNumberList);
        checkDuplicated(inputNumberList);
        checkInputZero(inputNumberList);
    }

    public static void checkInputNumber(String inputNumber) {
        checkNumberLength(inputNumber);
        checkCharDetect(inputNumber);
    }

    public static void checkNumberLength(String inputNumber) {
        if (!(inputNumber.length() == 1)) {
            throw new IllegalArgumentException("잘못된 길이의 숫자입니다");
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

