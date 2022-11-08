package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StringParsingUtilsTest {
    @Test
    void 변환된_타입은_리스트여야_한다() {
        // given
        String testInput = "123";

        // when
        List<BallNumber> testBallNumberList = StringParsingUtils.parseToBallNumber(testInput);

        // then
        assertThat(testBallNumberList instanceof List).isTrue();
    }

    @Test
    void input의_길이와_list의_원소_개수는_같다() {
        // given
        String testInput = "123";
        int testInputSize = 3;

        // when
        List<BallNumber> testBallNumberList = StringParsingUtils.parseToBallNumber(testInput);

        // then
        assertThat(testBallNumberList).hasSize(testInputSize);
    }
}