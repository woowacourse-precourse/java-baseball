package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NumbersTest {

    @Test
    void validation_숫자_개수_확인() {
        Numbers numbers = new Numbers(List.of(1, 2, 3, 4));
        boolean result = false;
        assertThat(result).isEqualTo(numbers.validation());
    }

    @Test
    void validation_숫자_정상_확인() {
        Numbers numbers = new Numbers(List.of(1, 2, 3));
        boolean result = true;
        assertThat(result).isEqualTo(numbers.validation());
    }
}
