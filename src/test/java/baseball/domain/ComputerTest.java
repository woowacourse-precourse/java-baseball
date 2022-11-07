package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {
    Computer computer;

    @BeforeEach
    void 컴퓨터_객체_생성() {
        computer = new Computer();
    }

    @Test
    void 컴퓨터_숫자_중복_여부() {
        computer.generateNumbers();
        List<Integer> computerNumbers = computer.getNumbers();

        assertThat(computerNumbers)
                .isEqualTo(computerNumbers
                        .stream()
                        .distinct()
                        .collect(Collectors.toList()));
    }

    @Test
    void 재시작_시_불일치_여부() {
        computer.generateNumbers();
        List<Integer> oldComputerNumber = computer.getNumbers();
        computer.generateNumbers();
        List<Integer> newComputerNumber = computer.getNumbers();

        assertThat(oldComputerNumber)
                .isNotEqualTo(newComputerNumber);
    }
}