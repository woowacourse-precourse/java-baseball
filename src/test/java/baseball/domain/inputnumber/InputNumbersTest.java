package baseball.domain.inputnumber;

import baseball.domain.SingleNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputNumbersTest {

    @ParameterizedTest(name = "중복_숫자를_입력하면_예외를_던진다")
    @ValueSource(strings = {"112", "111"})
    void 중복_숫자를_입력하면_예외를_던진다(String inputValue) {
        assertThatThrownBy(() -> new InputNumbers(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복 숫자는 입력할 수 없습니다.");
    }

    @ParameterizedTest(name = "세_자리가_아닌_문자열을_입력받으면_예외를_던진다")
    @ValueSource(strings = {"1234", "12"})
    void 세_자리가_아닌_문자열을_입력받으면_예외를_던진다(String inputValue) {
        assertThatThrownBy(() -> new InputNumbers(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("세자리의 숫자를 입력해 주세요.");
    }

    @Test
    void ball이_3일_경우_3을_리턴한다() {
        InputNumbers inputNumbers = new InputNumbers("123");
        List<SingleNumber> randomNumbers = List.of(
                new SingleNumber(0, 3),
                new SingleNumber(1, 1),
                new SingleNumber(2, 2)
        );

        assertThat(inputNumbers.ballCount(randomNumbers)).isEqualTo(3);
    }

    @Test
    void ball이_0일_경우_0을_리턴한다() {
        InputNumbers inputNumbers = new InputNumbers("123");
        List<SingleNumber> randomNumbers = List.of(
                new SingleNumber(0, 1),
                new SingleNumber(1, 2),
                new SingleNumber(2, 3)
        );

        assertThat(inputNumbers.ballCount(randomNumbers)).isEqualTo(0);
    }

    @Test
    void strike가_3일_경우_3을_리턴한다() {
        InputNumbers inputNumbers = new InputNumbers("123");
        List<SingleNumber> randomNumbers = List.of(
                new SingleNumber(0, 1),
                new SingleNumber(1, 2),
                new SingleNumber(2, 3)
        );

        assertThat(inputNumbers.strikeCount(randomNumbers)).isEqualTo(3);
    }

    @Test
    void strike가_0일_경우_0을_리턴한다() {
        InputNumbers inputNumbers = new InputNumbers("123");
        List<SingleNumber> randomNumbers = List.of(
                new SingleNumber(0, 3),
                new SingleNumber(1, 1),
                new SingleNumber(2, 2)
        );

        assertThat(inputNumbers.strikeCount(randomNumbers)).isEqualTo(0);
    }

}