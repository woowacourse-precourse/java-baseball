package baseball.logic;

import java.util.List;

public class inputException {

    public static boolean checkException(List<Integer> playerInput) {
        if (checkSame(playerInput) || checkThreedigit(playerInput) || checkZero(playerInput)) {
            return true;
        }
        return false;
    }

    public static boolean checkSame(List<Integer> playerInput) {
        for (int i = 0; i < playerInput.size() - 1; i++) {
            if (playerInput.get(i).equals(playerInput.get(i + 1))) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkThreedigit(List<Integer> playerInput) {
        if (playerInput.size() != 3) {
            return true;
        }
        return false;
    }

    public static boolean checkZero(List<Integer> playerInput) {
        if (playerInput.contains(0)) {
            return true;
        }
        return false;
    }
}
