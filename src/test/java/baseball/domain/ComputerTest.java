package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class ComputerTest {

    @Test
    void 컴퓨터가_만드는_정답은_3자리_숫자이다() {
        // given
        Computer computer = new Computer();
        int expectedLength = 3;

        // when
        computer.generateAnswer();

        // then
        assertThat(computer.getAnswer().length()).isEqualTo(expectedLength);
    }
}