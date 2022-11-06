package baseball.domain.Computer;

import static baseball.domain.Validation.Ball.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerTest {
    private Computer computer;

    @BeforeEach
    void createComputer() {
        computer = new Computer();
    }

    @Test
    @DisplayName("컴퓨터_생성_난수를_테스트한다")
    void 컴퓨터_생성_난수() {
        computer.generateRandomNumbers();

        assertAll(
                () -> assertThat(computer.getBallNumbers().size()).isEqualTo(COUNT.getValue()),
                () -> assertThat(computer.getBallNumbers()).allMatch(number -> number >= MIN.getValue() && number <= MAX.getValue()),
                () -> assertThat(computer.getBallNumbers().stream().distinct().count()).isEqualTo(COUNT.getValue())
                );
    }

}
