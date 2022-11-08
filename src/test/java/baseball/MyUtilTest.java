package baseball;

import org.junit.jupiter.api.Test;

public class MyUtilTest {

    @Test
    void 세자리_난수_생성() {
        for (int i = 0; i < 10000000; ++i) {
            String randomNumber = MyUtil.createRandomNumber();
            hasDifferentDigit(randomNumber);
        }
    }

    private void hasDifferentDigit(String randomNumber) throws IllegalArgumentException {
        char first = randomNumber.charAt(0), second = randomNumber.charAt(1), third = randomNumber.charAt(2);
        if (first == second || second == third || first == third) {
            throw new IllegalArgumentException();
        }
    }
}
