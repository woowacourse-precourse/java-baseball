package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import baseball.utils.BaseballNumbersGenerator;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ResultTest {

    private static final BaseballNumbersGenerator numberGenerator = new TestNumberGenerator();
    private static Baseball baseball;

    @BeforeAll
    static void init() {
        baseball = new Baseball(numberGenerator);
    }

    @Test
    void makeMessage_낫싱_일때_올바른_메세지() {
        Numbers userNumbers = new Numbers(Arrays.asList(4,5,6));
        Result result = new Result(baseball, userNumbers);
        assertThat(result.makeMessage()).isEqualTo("낫싱");
    }

    @Test
    void makeMessage_볼_일때_올바른_메세지() {
        Numbers userNumbers = new Numbers(Arrays.asList(3,1,2));
        Result result = new Result(baseball, userNumbers);
        assertThat(result.makeMessage()).isEqualTo("3볼");
    }

    @Test
    void makeMessage_스트라이크_일때_올바른_메세지() {
        Numbers userNumbers = new Numbers(Arrays.asList(1,5,6));
        Result result = new Result(baseball, userNumbers);
        assertThat(result.makeMessage()).isEqualTo("1스트라이크");
    }

    @Test
    void makeMessage_스트라이크_와_볼_일때_올바른_메세지() {
        Numbers userNumbers = new Numbers(Arrays.asList(1,3,2));
        Result result = new Result(baseball, userNumbers);
        assertThat(result.makeMessage()).isEqualTo("2볼 1스트라이크");
    }

    static class TestNumberGenerator implements BaseballNumbersGenerator {

        @Override
        public List<Integer> generate() {
            return Arrays.asList(1,2,3);
        }
    }
}