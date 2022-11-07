package baseball;

import static baseball.type.NumberType.NUMBER_SIZE;
import static org.assertj.core.api.Assertions.assertThat;

import baseball.service.ComputerNumberService;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class ComputerNumberTest {

    @Test
    void 컴퓨터_숫자_갯수_검증() {
        List<Integer> computerNumbers = ComputerNumberService.generate();
        int computerNumbersSize = computerNumbers.size();

        assertThat(computerNumbersSize).isEqualTo(NUMBER_SIZE.getValue());
    }

    @Test
    void 컴퓨터_숫자_중복_여부_검증() {
        List<Integer> computerNumbers = ComputerNumberService.generate();

        assertThat(computerNumbers)
                .isNotNull()
                .isEqualTo(computerNumbers
                        .stream()
                        .distinct()
                        .collect(Collectors.toList()));
    }
}
