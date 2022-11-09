package baseball.computer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest {

    @DisplayName("컴퓨터가 서로 다른 세자리 숫자를 생성하는데 성공한다")
    @Test
    void 컴퓨터가_세자리_숫자를_생성() {
        // given
        Computer computer = new Computer();

        // when
        computer.generateRandomNumber();
        List<Integer> computerHoldNumbers = computer.getComputerHoldNumbers();

        // then
        assertThat(computerHoldNumbers).hasSize(3);
        assertThat(
                computerHoldNumbers.stream().collect(Collectors.toSet())
        ).hasSize(3);
    }
}
