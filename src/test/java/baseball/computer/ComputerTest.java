package baseball.computer;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.computer.generator.NumberGenerator;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ComputerTest {
    private Computer computer;

    @BeforeEach
    void init() {
        computer = new Computer();
    }

    @Test
    void 설정_숫자_확인() {
        // given
        List<Integer> settingNumber = List.of(1,2,3);

        // when
        NumberGenerator.setTestNumber(settingNumber);
        computer.initComputer();

        // then
        assertThat(settingNumber).isEqualTo(computer.getGameNumber());
    }

    @Test
    void 설정_숫자_1회용_확인() {
        // given
        List<Integer> settingNumber = List.of(1,2,3);

        // when
        NumberGenerator.setTestNumber(settingNumber);
        computer.initComputer();
        List<Integer> previousNumber = computer.getGameNumber();
        computer.initComputer();

        // then
        assertThat(previousNumber).isNotEqualTo(computer.getGameNumber());
    }
}
