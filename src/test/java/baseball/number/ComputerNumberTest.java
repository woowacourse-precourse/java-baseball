package baseball.number;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerNumberTest {
    @Test
    void 새로_생성한_컴퓨터_숫자의_중복_여부_검증() {
        NumberDto computerNumber = ComputerNumber.generate();

        assertThat(computerNumber.getNumber())
                .isEqualTo(computerNumber
                        .getNumber()
                        .stream()
                        .distinct()
                        .collect(Collectors.toList()));
    }

    @Test
    void 재시작_했을_때_이전_숫자와_새로운_숫자가_다른지_검증() {
        NumberDto computerNumber = ComputerNumber.generate();
        List<Integer> oldComputerNumber = computerNumber.getNumber();
        List<Integer> newComputerNumber = ComputerNumber.generate(computerNumber).getNumber();

        assertThat(oldComputerNumber)
                .isNotEqualTo(newComputerNumber);
    }
}