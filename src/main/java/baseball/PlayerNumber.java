package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class PlayerNumber {
    public String playerNumber;

    public PlayerNumber() {
        inputNumber();
        validateIsOnlyDigit(playerNumber);
        validateNumberLength(playerNumber);
        validateNumberRange(playerNumber);
        validateDuplication(playerNumber);
    }

    private void inputNumber() {
        System.out.println("숫자를 입력해주세요 : ");
        this.playerNumber = Console.readLine();
    }

    public LinkedHashMap<Integer, Integer> pickNumbers() {
        LinkedHashMap<Integer, Integer> playerNumbers = new LinkedHashMap<>();
        for (int i = 0; i < GameConstant.NUMBER_COUNT; i++) {
            int digit = playerNumber.charAt(i) - '0';
            playerNumbers.put(i, digit);
        }
        return playerNumbers;
    }

    public static void validateIsOnlyDigit(String playerNumber) {
        if (!isOnlyDigit(playerNumber)) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
    }

    private static boolean isOnlyDigit(String playerNumber) {
        return playerNumber.chars().allMatch(Character::isDigit);
    }

    public static void validateNumberLength(String playerNumber) {
        if (playerNumber.length() != GameConstant.NUMBER_COUNT) {
            throw new IllegalArgumentException("3자리 수를 입력해주세요.");
        }
    }

    public static void validateNumberRange(String playerNumber) {
        if (isOutOfRange(playerNumber)) {
            throw new IllegalArgumentException("1에서 9까지의 숫자만 입력할 수 있습니다.");
        }
    }

    private static boolean isOutOfRange(String playerNumber) {
        return Arrays.stream(playerNumber.split(""))
                .mapToInt(Integer::parseInt)
                .filter(n -> (n >= GameConstant.MIN_VALUE && n <= GameConstant.MAX_VALUE))
                .count() != playerNumber.length();
    }

    public static void validateDuplication(String playerNumber) {
        if (isDuplicated(playerNumber)) {
            throw new IllegalArgumentException("서로 다른 숫자를 입력해주세요.");
        }
    }

    private static boolean isDuplicated(String playerNumber) {
        return Arrays.stream(playerNumber.split(""))
                .distinct()
                .count() != playerNumber.length();
    }
}
