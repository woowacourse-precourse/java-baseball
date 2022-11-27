package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import baseball.utils.BaseballNumbersGenerator;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class BaseballTest {
    private static final BaseballNumbersGenerator numbersGenerator = new TestNumberGenerator();
    private static Baseball baseball;

    @BeforeAll
    static void init() {
        baseball = new Baseball(numbersGenerator);
    }

    @Test
    void isGameContinue_올바른_반환값() {
        Numbers userNumbers = new Numbers(Arrays.asList(1,2,3));
        baseball.countStrike(userNumbers);
        assertThat(baseball.isGameContinue()).isEqualTo(false);
    }

    @Test
    void countStrike_올바른_반환값() {
        Numbers userNumbers = new Numbers(Arrays.asList(1,3,2));
        assertThat(baseball.countStrike(userNumbers)).isEqualTo(1);
    }

    @Test
    void countBall_올바른_반환값() {
        Numbers userNumbers = new Numbers(Arrays.asList(3,1,2));
        assertThat(baseball.countBall(userNumbers)).isEqualTo(3);
    }

    static class TestNumberGenerator implements BaseballNumbersGenerator {

        @Override
        public List<Integer> generate() {
            return Arrays.asList(1,2,3);
        }
    }
}