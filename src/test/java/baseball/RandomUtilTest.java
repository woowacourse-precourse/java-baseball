package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;

public class RandomUtilTest {

    @Test
    void 랜덤_수_생성() {
        Integer randomNumber = RandomUtil.createRandomNumber();
        if (randomNumber == null) {
            fail();
        }
    }

    @Test
    void 랜덤_수의_범위는_123부터_987() {
        int randomNumber = RandomUtil.createRandomNumber();

        assertThat(randomNumber).isBetween(123, 987);
    }
}
