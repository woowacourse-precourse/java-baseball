package baseball;

import baseball.model.Computer;
import baseball.model.BaseballNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest {

    @DisplayName(value = "컴퓨터 난수 생성 테스트")
    @Test
    void computerConstructorTest() throws Exception {
        Computer computer = new Computer();
        computer.pickRandomNumbers();

        for (int i = 0; i < 3; i++) {
            BaseballNumber computerBaseballNumber = computer.findComputerNumber(i);
            assertThat(computerBaseballNumber).isInstanceOf(BaseballNumber.class);
        }
    }

    @DisplayName(value = "컴퓨터 난수 중복 테스트")
    @Test
    void computerDuplicateNumber() throws Exception {
        Computer computer = new Computer();

        for (int i = 0; i < 10000; i++) {
            computer.pickRandomNumbers();

            assertThat(computer.findComputerNumber(0).getNumber())
                    .isNotEqualTo(computer.findComputerNumber(1).getNumber());
            assertThat(computer.findComputerNumber(1).getNumber())
                    .isNotEqualTo(computer.findComputerNumber(2).getNumber());
            assertThat(computer.findComputerNumber(2).getNumber())
                    .isNotEqualTo(computer.findComputerNumber(0).getNumber());
        }
    }

}
