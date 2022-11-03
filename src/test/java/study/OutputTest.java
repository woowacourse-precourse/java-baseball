package study;

import baseball.Output;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OutputTest {

    @Test
    void 정상_결과_확인() {
        assertThat("2볼 1스트라이크").isEqualTo(Output.result(List.of(2,1,3), List.of(3,1,2)));
    }

    @Test
    void 스트라이크_3개_확인() {
        assertThat("3스트라이크").isEqualTo(Output.result(List.of(3,1,2), List.of(3,1,2)));
    }

    @Test
    void 볼_3개_확인() {
        assertThat("3볼").isEqualTo(Output.result(List.of(1,2,3), List.of(3,1,2)));
    }

    @Test
    void 낫싱_확인() {
        assertThat("낫싱").isEqualTo(Output.result(List.of(1,2,3), List.of(4,5,6)));
    }
}
