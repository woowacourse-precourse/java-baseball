package baseball.domain.computer;

import baseball.domain.number.BaseBallGameNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Computer 는 ")
class ComputerTest {

    @ParameterizedTest(name = "BaseBallGameNumbers({arguments})를 가지고 생성된다.")
    @ValueSource(strings = {"123", "456", "789"})
    void playerConstructedWithBaseBallGameNumbers(final String input) {
        // given
        BaseBallGameNumbers baseBallGameNumbers = new BaseBallGameNumbers(input);

        // when
        Computer computer = new Computer(baseBallGameNumbers);

        // then
        assertThat(computer.baseBallGameNumbers()).isEqualTo(baseBallGameNumbers);
    }
}