package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class NumberToListChangerTest {

    @Test
    void change_int_to_list() {
        assertThat(NumberToListChanger.change("235")).isEqualTo(List.of(2, 3, 5));

        assertThat(NumberToListChanger.change("456")).isEqualTo(List.of(4, 5, 6));
    }
}
