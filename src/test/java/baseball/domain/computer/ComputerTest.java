package baseball.domain.computer;

import baseball.domain.number.BaseBallGameNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Computer 는 ")
class ComputerTest {

    @Test
    @DisplayName("BaseBallGameNumber를 가지고 생성된다.")
    void playerConstructedWithBaseBallGameNumbers() {
        // given
        String input = "123";
        BaseBallGameNumbers baseBallGameNumbers = new BaseBallGameNumbers(input);

        // when
        Computer computer = new Computer(baseBallGameNumbers);

        // then
        assertThat(computer.baseBallGameNumbers()).isEqualTo(baseBallGameNumbers);
    }
}