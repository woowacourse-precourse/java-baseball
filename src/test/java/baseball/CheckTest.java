package baseball;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CheckTest {
    Check_function Check = new Check_function();

    @Test
    void check_valid_string_alphabet_test() {
        String input_number = "1g3";

        assertSimpleTest(() ->
                assertThatThrownBy(() -> Check.check_valid(input_number))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void check_valid_string_length_test() {
        String input_number = "12";

        assertSimpleTest(() ->
                assertThatThrownBy(() -> Check.check_valid(input_number))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void check_valid_string_duplicate_test() {
        String input_number = "122";

        assertSimpleTest(() ->
                assertThatThrownBy(() -> Check.check_valid(input_number))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void check_valid_integer_range_test() {
        Integer input_number = 3;

        assertSimpleTest(() ->
                assertThatThrownBy(() -> Check.check_valid(input_number))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
