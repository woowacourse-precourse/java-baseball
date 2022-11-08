package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ComputerServiceTest {

    ComputerService computer = new ComputerService();

    @Test
    void 랜덤_숫자_자리수_테스트() {
        List<Integer> computerNumber = computer.createComputerNumber();

        assertThat(computerNumber.size()).isEqualTo(3);
    }

    @Test
    void 랜덤_숫자_범위_테스트() {
        List<Integer> computerNumber = computer.createComputerNumber();

        computerNumber
                .forEach(number -> assertThat(number).isBetween(1, 9));
    }
}
