package baseball;

import java.util.List;

public class InputException {
    private static final int LENGTH = 3;
    public static int changeStrToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다. 프로그램을 종료합니다.");
        }
    }

    public static boolean isOverlap(List<Integer> numArr) {
        if (numArr.size() == numArr.stream().distinct().count()) {
            return false;
        }

        return true;
    }

    public static boolean isNotSizeThree(List<Integer> numArr) {
        if (numArr.size() != LENGTH) {
            return true;
        }

        return false;
    }

    public static boolean hasZero(List<Integer> numArr) {
        if(numArr.contains(0)) {
            return true;
        }

        return false;
    }
}
