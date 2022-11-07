package baseball.util;

import static baseball.util.TypeConversion.stringToIntList;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class TypeConversionTest {

    @Test
    void stringToIntList_매서드_사용시_String을_Integer_형_List_로_변환() {
        // given
        String userInput = "123";

        // when
        List<Integer> result = stringToIntList(userInput);

        // then
        assertThat(result).containsExactly(1, 2, 3);
    }
}