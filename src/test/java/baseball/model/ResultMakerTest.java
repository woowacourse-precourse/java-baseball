package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ResultMakerTest {
    private ResultMaker resultMaker;
    private List<Integer> testList = Arrays.asList(3, 6, 9);

    @BeforeEach
    void setUp() {
        resultMaker = new ResultMaker();
    }

    @ParameterizedTest
    @CsvSource({"3,7,8,1스트라이크", "3,6,5,2스트라이크", "3,6,9,3스트라이크"
            , "4,8,6,1볼", "9,5,6,2볼", "9,3,6,3볼", "9,6,5,1볼 1스트라이크", "3,9,6,2볼 1스트라이크"
            , "5,7,1,낫싱"})
    public void compare(int num1, int num2, int num3, String expected) {
        String result = resultMaker.compare(testList, Arrays.asList(num1, num2, num3));
        assertThat(result).isEqualTo(expected);
    }
    /*@Test
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
    }*/
}