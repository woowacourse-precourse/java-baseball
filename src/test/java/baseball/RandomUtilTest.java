package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    @Test
    void 랜덤_수의_각_자릿수는_서로_다른_수() {
        List<String> numberEachDigitList = Arrays.asList(String.valueOf(RandomUtil.createRandomNumber()).split(""));
        Set<String> numberEachDigitSet = new HashSet<>(numberEachDigitList);

        assertThat(numberEachDigitSet.size()).isEqualTo(3);
    }
}
