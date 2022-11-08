package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ConvertTest {

    @Test
    void convertNumberToDigit() {

        String number = "123";
        List<Integer> result = List.of(1, 2, 3);

        assertThat(Convert.convertNumberToDigit(number)).isEqualTo(result);

    }
}