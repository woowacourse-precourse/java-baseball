package baseball.outputgenerator;

import baseball.numbercomparator.Score;
import org.junit.jupiter.api.Test;

import static baseball.outputgenerator.OutputGenerator.outputGenerator;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * OutputGenerator 클래스와 관련된 Test 클래스입니다.
 * @version 1.0.0
 * @author CHO MinHO
 */
class OutputGeneratorTest {

    /**
     * 각 게임 결과에 따라 알맞은 GameResult 클래스를 반환하는지 테스트하는 메서드입니다.
     */
    @Test
    void outputGeneratorTest() {
        // 1. 1볼 1스트라이크
        GameResult gameResult = outputGenerator(new Score(1, 1));
        assertThat(gameResult.isSuccess()).isFalse();
        assertThat(gameResult.getMessage()).isEqualTo("1볼 1스트라이크");

        // 2. 1볼 0스트라이크
        gameResult = outputGenerator(new Score(0, 1));
        assertThat(gameResult.isSuccess()).isFalse();
        assertThat(gameResult.getMessage()).isEqualTo("1볼");

        // 3. 0볼 1스트라이크
        gameResult = outputGenerator(new Score(1, 0));
        assertThat(gameResult.isSuccess()).isFalse();
        assertThat(gameResult.getMessage()).isEqualTo("1스트라이크");

        // 4. 0볼 0스트라이크
        gameResult = outputGenerator(new Score(0, 0));
        assertThat(gameResult.isSuccess()).isFalse();
        assertThat(gameResult.getMessage()).isEqualTo("낫싱");

        // 5. 0볼 3스트라이크
        gameResult = outputGenerator(new Score(3, 0));
        assertThat(gameResult.isSuccess()).isTrue();
        assertThat(gameResult.getMessage()).isEqualTo("3스트라이크");
    }
}