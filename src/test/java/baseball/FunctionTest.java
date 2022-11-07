package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FunctionTest {

    @Test
    public void TEST1_1() {
        List<Integer> computerNumbers = Utils.pickComputerNumber();

        Assertions.assertThat(computerNumbers).hasSize(3);
        Assertions.assertThat(computerNumbers.get(0)).isNotEqualTo(computerNumbers.get(1)).isNotEqualTo(computerNumbers.get(2));
    }
}
