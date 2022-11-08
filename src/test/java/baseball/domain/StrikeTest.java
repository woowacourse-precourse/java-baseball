package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Strike 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StrikeTest {
    private final int STRIKE_LOWER_BOUND = 0;
    private final int STRIKE_UPPER_BOUND = 3;

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void valueOf_메서드는_만약_0과_3사이의_값을_입력받으면_Strike_객체를_리턴한다(int count) {
        assertThat(Strike.valueOf(count)).isInstanceOf(Strike.class);
    }

    @Test
    void valueOf_메서드는_만약_주어진_범위보다_더_높은_값을_입력받으면_BaseballGameException을_던진다() {
        final Integer givenNumber = STRIKE_UPPER_BOUND + 1;

        assertThatThrownBy(() -> Strike.valueOf(givenNumber))
                .isInstanceOf(BaseballGameException.class);
    }

    @Test
    void valueOf_메서드는_만약_주어진_범위보다_더_낮은_값을_입력받으면_BaseballGameException을_던진다() {
        final Integer givenNumber = STRIKE_LOWER_BOUND - 1;
        assertThatThrownBy(() -> Strike.valueOf(givenNumber))
                .isInstanceOf(BaseballGameException.class);
    }

    @Test
    void isStrikeOut_메서드는_만약_객체의_값이_3이라면_참을_리턴한다() {
        final Strike givenStrike = Strike.valueOf(3);
        assertThat(givenStrike.isStrikeOut()).isTrue();
    }

    @Test
    void isStrikeOut_메서드는_만약_객체의_값이_3이_아니라면_거짓을_리턴한다() {
        final Strike givenStrike = Strike.valueOf(2);
        assertThat(givenStrike.isStrikeOut()).isFalse();
    }

    @Test
    void toString_메서드는_만약_스트라이크_카운트가_0인_경우_빈_문자열을_리턴한다() {
        final Strike strike = Strike.valueOf(0);
        assertThat(strike.toString()).isEqualTo("");
    }

    @ParameterizedTest(name = "스트라이크 카운트가 {0}인 경우 {1}을 리턴한다")
    @CsvSource(value = {"1, 1스트라이크", "2, 2스트라이크", "3, 3스트라이크"})
    void toString_메서드는_만약_스트라이크_카운트가_0이_아닌_경우_X스트라이크_문자열을_리턴한다(int count, String result) {
        Strike strike = Strike.valueOf(count);
        assertThat(strike.toString()).isEqualTo(result);
    }
}
