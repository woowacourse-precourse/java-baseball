package baseball.computer;

import baseball.computer.Computer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class ComputerTest {

    @DisplayName("컴퓨터가 서로 다른 세자리 숫자를 생성하는데 성공한다")
    @Test
    void 컴퓨터가_세자리_숫자를_생성() {
        Computer computer = new Computer();

        computer.generateRandomNumber();
        List<Integer> computerHoldNumbers = computer.getComputerHoldNumbers();

        Assertions.assertThat(computerHoldNumbers).hasSize(3);
        Assertions.assertThat(
                computerHoldNumbers.stream().collect(Collectors.toSet())
        ).hasSize(3);
    }
}
