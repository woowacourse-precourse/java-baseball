package baseball.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class ComputerTest {

    @Test
    void 서로_다른_3개의_숫자_선택_테스트() {

        Computer computer = new Computer();
        int validateCnt = 0;

        List<Integer> selectNumberList = computer.selectNumbers();
        for (Integer number : selectNumberList) {
            for (Integer selectNumber : selectNumberList) {
                if (number == selectNumber) validateCnt++;
            }
        }

        assertThat(selectNumberList).hasSize(3);
        assertThat(validateCnt).isEqualTo(3);

    }
}