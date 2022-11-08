package baseball;
import java.util.*;
public class CheckingValidArgument {
    private final int maxNumberSize = 3;

    // 입력값이 세자리 숫자인지 확인하고 아니라면 예외처리
    public void MaxRangeNumber(String number) throws IllegalArgumentException {
        if (number.length() != maxNumberSize) {
            throw new IllegalArgumentException();
        }
    }

    // 입력값이 옳바른 숫자인지 확인하고 아니라면 예외처리
    public void TrueNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

}