package baseball;

import baseball.utils.Util;

public class InputVerifier {
    public void verifyInput(String input) {
        try {
            isNumber(input);
            isThreeDigits(input);
            isDistinctDigits(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 값 입력입니다.");
        }
    }

    private void isNumber(String input) {
        Integer.parseInt(input);
    }
}
