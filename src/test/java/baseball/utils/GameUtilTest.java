package baseball.utils;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("GameUtil 테스트")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class GameUtilTest {
    @Test
    @DisplayName("숫자 램덤 생성")
    void generate_number() {
        int number = GameUtil.pickNumber(3);
        List<Integer> splitOneDigits = GameUtil.splitNumberToOneDigits(number);

        assertThat(number).isNotNegative();
        assertThat(splitOneDigits)
                .allMatch(num -> (num >= 1 && num <= 9))
                .doesNotHaveDuplicates()
                .hasSize(3);
    }
}
