package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ResultMakerTest {
    private ResultMaker resultMaker;

    @BeforeEach
    void setUp() {
        resultMaker = new ResultMaker();
    }

    @Test
    void 스트라이크원() {
        String result = resultMaker.compare(Arrays.asList(1,2,3),Arrays.asList(1,4,5));
        assertThat(result).isEqualTo("1스트라이크");
    }
    @Test
    void 스트라이크투() {
        String result = resultMaker.compare(Arrays.asList(3,4,5),Arrays.asList(3,4,7));
        assertThat(result).isEqualTo("2스트라이크");
    }
    @Test
    void 스트라이크쓰리() {
        String result = resultMaker.compare(Arrays.asList(2,4,8),Arrays.asList(2,4,8));
        assertThat(result).isEqualTo("3스트라이크");
    }
    @Test
    void 원볼() {
        String result = resultMaker.compare(Arrays.asList(2,1,7),Arrays.asList(3,5,1));
        assertThat(result).isEqualTo("1볼");
    }

    @Test
    void 투볼() {
        String result = resultMaker.compare(Arrays.asList(3,4,7),Arrays.asList(7,3,2));
        assertThat(result).isEqualTo("2볼");
    }
    @Test
    void 쓰리볼() {
        String result = resultMaker.compare(Arrays.asList(2,6,9),Arrays.asList(9,1,2));
        assertThat(result).isEqualTo("3볼");
    }
    @Test
    void 낫싱() {
        String result = resultMaker.compare(Arrays.asList(1,7,8),Arrays.asList(2,3,4));
        assertThat(result).isEqualTo("낫싱");
    }
}