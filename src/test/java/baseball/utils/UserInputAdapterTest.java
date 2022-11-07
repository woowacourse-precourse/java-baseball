package baseball.utils;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class UserInputAdapterTest {
    @Test
    void 문자열_정수_배열로_변환() {
        //given
        String testStr = "123";

        //when
        List<Integer> testArray = UserInputAdapter.changeStrToIntegerArray(testStr);

        //then
        assertThat(testArray).isEqualTo(List.of(1, 2, 3));
    }

    @Test
    void 문자열_정수로_변환() {
        //given
        String testStr = "1";

        //when
        int testInt = UserInputAdapter.changeStrToInt(testStr);

        //then
        assertThat(testInt).isEqualTo(1);
    }
}