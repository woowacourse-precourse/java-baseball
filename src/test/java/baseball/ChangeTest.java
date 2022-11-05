package baseball;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class ChangeTest {

    @Test
    void numberToList_숫자의_각_자리수가_리스트로_변환되는지_확인() {
        String input = "123";

        assertThat(Change.numberToList(input)).isEqualTo(Arrays.asList(1,2,3));
    }
}
