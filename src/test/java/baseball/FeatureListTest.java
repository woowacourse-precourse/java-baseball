package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static baseball.Application.GenerateNonDuplicateRandomNumber;
import static org.assertj.core.api.Assertions.assertThat;

public class FeatureListTest {

    @Test
    void 이미_만들어진_숫자가_아닌_난수_생성_검증() {
        List<Integer> list = List.of(1, 2);
        assertThat(GenerateNonDuplicateRandomNumber(list)).isNotIn(1, 2);
    }
}
