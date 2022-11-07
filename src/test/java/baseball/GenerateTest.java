package baseball;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GenerateTest {
    Generate_function Generate = new Generate_function();

    @Test
    void generate_numbers_test() {
        assertRandomNumberInRangeTest(
                () -> {
                    String out = Generate.generate_numbers();
                    assertThat(out).isEqualTo("135");
                },
                1, 3, 5
        );
    }
}
