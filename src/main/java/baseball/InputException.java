package baseball;

import java.util.List;

public class InputException {
    private static final int LENGTH = 3;
    public static int changeStrToInt(String input) {
        int number;

        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다. 프로그램을 종료합니다.");
        }

        return number;
    }

    public static boolean isOverlap(List<Integer> numArr) {
        boolean overlap = true;

        if (numArr.size() == numArr.stream().distinct().count()) {
            overlap = false;
        }

        return overlap;
    }

    public static boolean isNotSizeThree(List<Integer> numArr) {
        boolean notSizeThree = false;

        if (numArr.size() != LENGTH) {
            notSizeThree = true;
        }

        return notSizeThree;
    }

    public static boolean hasZero(List<Integer> numArr) {
        boolean isZero = false;

        for (int i : numArr) {
            if (i == 0) {
                isZero = true;
            }
        }

        return isZero;
    }
}
