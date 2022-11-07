package baseball;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CompareTest {
    Compare_function Compare = new Compare_function();

    @Test
    void Compare_number_test() {
        String input_number = "123";
        String generated_number = "135";
        List<Integer> result = List.of(1, 1);

        List<Integer> ball_and_strike = Compare.Compare_number(input_number, generated_number);
        assertThat(ball_and_strike).isEqualTo(result);
    }
}
