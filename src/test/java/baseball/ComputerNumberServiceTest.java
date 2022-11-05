package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.service.ComputerNumberService;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class ComputerNumberServiceTest {

    @Test
    void 컴퓨터_숫자_갯수_검증() {
        List<Integer> computerNumbers = ComputerNumberService.generate();
        int computerNumbersSize = computerNumbers.size();

        assertThat(computerNumbersSize).isEqualTo(3);
    }

    @Test
    void 컴퓨터_숫자_중복_여부_검증() {
        List<Integer> computerNumbers = ComputerNumberService.generate();

        assertThat(computerNumbers)
                .isEqualTo(computerNumbers
                        .stream()
                        .distinct()
                        .collect(Collectors.toList()));
    }
}
