package baseball.utils;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("GameUtil 테스트")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class GameUtilTest {
    @Test
    void 숫자_랜덤_생성() {
        int number = GameUtil.pickNumber(3);
        List<Integer> splitOneDigits = GameUtil.splitNumberToOneDigitNumbers(number);

        assertThat(number).isNotNegative();
        assertThat(splitOneDigits)
                .allMatch(num -> (num >= 1 && num <= 9))
                .doesNotHaveDuplicates()
                .hasSize(3);
    }

    @ParameterizedTest(name = "숫자 유효성 체크 => {0}")
    @ValueSource(ints = {2, 21, 210, 212, 220, 221, 222, 2134, 2243})
    void 숫자_유효성_체크(int number) {
        assertThatThrownBy(() -> GameUtil.validateNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_파싱_예외_체크() {
        assertThatThrownBy(() -> GameUtil.parseInt("number"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
