package baseball.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OffenseNumberGeneratorTest {

    private static final String NOT_ONLY_NUMBER_ERROR_MESSAGE = "공격 값이 유효한 숫자로만 이루어지지 않았습니다.";
    private static final String NOT_DISTINCT_ERROR_MESSAGE = "공격 값이 서로 다른 숫자가 아닙니다.";
    private static final String SIZE_ERROR_MESSAGE = "공격 값의 길이가 3이 아닙니다.";
    private static final OffenseNumberGenerator offenseNumberGenerator = OffenseNumberGenerator.getInstance();

    @Test
    void 유효한_공격_값을_넣었을_시_리스트를_반환() {
        String input = "123";
        List<Integer> result = List.of(1, 2, 3);

        List<Integer> offenseNumbers = offenseNumberGenerator.generateOffenseNumbers(input);

        Assertions.assertThat(offenseNumbers).isEqualTo(result);
    }

    @Test
    void 유효하지_않은_공격_값을_넣었을_때_공격값의_길이가_0인_경우_예외_발생() {
        String input = "";

        assertThatThrownBy(() -> offenseNumberGenerator.generateOffenseNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(SIZE_ERROR_MESSAGE);
    }

    @Test
    void 유효하지_않은_공격_값을_넣었을_때_공격값의_길이가_3보다_작은_경우_예외_발생() {
        String input = "12";

        assertThatThrownBy(() -> offenseNumberGenerator.generateOffenseNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(SIZE_ERROR_MESSAGE);
    }

    @Test
    void 유효하지_않은_공격_값을_넣었을_때_공격값의_길이가_3을_초과한_경우_예외_발생() {
        String input = "1234";

        assertThatThrownBy(() -> offenseNumberGenerator.generateOffenseNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(SIZE_ERROR_MESSAGE);
    }

    @Test
    void 유효하지_않은_공격_값을_넣었을_때_공격값에_유효한_숫자가_아닌_경우() {
        String input = "103";

        assertThatThrownBy(() -> offenseNumberGenerator.generateOffenseNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_ONLY_NUMBER_ERROR_MESSAGE);
    }

    @Test
    void 유효하지_않은_공격_값을_넣었을_때_숫자가_아닌_값이_들어간_경우() {
        String input = "1a3";

        assertThatThrownBy(() -> offenseNumberGenerator.generateOffenseNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_ONLY_NUMBER_ERROR_MESSAGE);
    }

    @Test
    void 유효하지_않은_공격_값을_넣었을_때_서로_다른_숫자이나_0이_들어간_경우_예외_발생() {
        String input = "103";

        assertThatThrownBy(() -> offenseNumberGenerator.generateOffenseNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_ONLY_NUMBER_ERROR_MESSAGE);
    }

    @Test
    void 유효하지_않은_공격_값을_넣었을_때_중복된_값이_들어간_경우_예외_발생() {
        String input = "131";

        assertThatThrownBy(() -> offenseNumberGenerator.generateOffenseNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_DISTINCT_ERROR_MESSAGE);
    }
}