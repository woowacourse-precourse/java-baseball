package baseball.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class RandomUtilTest {

    @Test
    void 생성된_숫자_검증() {
        RandomUtil randomUtil = new RandomUtil();

        for (int i = 0; i < 1000; i++) {
            String generated = randomUtil.generateNumber();

            assertEquals(3, generated.length());
            assertFalse(generated.contains("0"));
        }
    }

}