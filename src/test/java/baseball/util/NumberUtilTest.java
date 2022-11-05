package baseball.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

import static baseball.util.NumberUtil.*;

public class NumberUtilTest {
    @DisplayName("컴퓨터의 정답 생성 기능 테스트")
    @Test
    public void checkRandomThreeNumberTest() {
        List<Integer> numberList = createRandomNumber();

        assertThat(numberList.size()).isEqualTo(3);
        assertThat(numberList.get(0)).isGreaterThan(0).isLessThan(10);
        assertThat(numberList.get(1)).isGreaterThan(0).isLessThan(10);
        assertThat(numberList.get(2)).isGreaterThan(0).isLessThan(10);
        for (int index = 0; index < numberList.size() - 1; index++) {
            for (int compareIndex = index + 1; compareIndex < numberList.size(); compareIndex++)
            assertThat(numberList.get(index)).isNotEqualTo(numberList.get(compareIndex));
        }
    }
}
