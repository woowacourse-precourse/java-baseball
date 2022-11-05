package baseball.domain.player;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.RepeatedTest;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ComputerTest {

    @RepeatedTest(100)
    void 테스트는_랜덤한_3자리_정답을_만들어내며_1_9사이의_숫자로_구성됩니다() {
        var computer = new Computer();
        var actual = computer.numbers();

        assertThat(actual).hasSize(3);
        actual.forEach(n -> assertThat(n.number()).isLessThanOrEqualTo(9)
                .isGreaterThanOrEqualTo(1));
    }
}
