package baseball.baesball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.List;

import static baseball.game.GameRule.BASEBALL_MAX_SIZE;
import static org.assertj.core.api.Assertions.assertThat;

class ComputerBaseballGeneratorTest {
    private final BaseballGenerator baseballGenerator = new ComputerBaseballGenerator();

    @RepeatedTest(1000)
    @DisplayName("컴퓨터 야구공 생성 성공 테스트")
    void whenCreateBaseballThenSuccessTest() {
        Baseball baseball = baseballGenerator.generateBaseball();
        List<Integer> findBaseballs = baseball.getBaseballs();
        assertThat(findBaseballs).hasSize(BASEBALL_MAX_SIZE.getRule());
    }
}