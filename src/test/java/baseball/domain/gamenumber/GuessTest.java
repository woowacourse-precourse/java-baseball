package baseball.domain.gamenumber;

import baseball.domain.baseballnumber.BaseballNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static baseball.domain.baseballnumber.BaseballNumberListGenerator.baseballNumberList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GuessTest {

    @ParameterizedTest(name = "중복_숫자를_입력하면_예외를_던진다")
    @ValueSource(strings = {"112", "111"})
    void 중복_숫자를_입력하면_예외를_던진다(String inputValue) {
        assertThatThrownBy(() -> new Guess(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복 숫자는 입력할 수 없습니다.");
    }

    @ParameterizedTest(name = "세_자리가_아닌_문자열을_입력받으면_예외를_던진다")
    @ValueSource(strings = {"1234", "12"})
    void 세_자리가_아닌_문자열을_입력받으면_예외를_던진다(String inputValue) {
        assertThatThrownBy(() -> new Guess(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("세자리의 숫자를 입력해 주세요.");
    }

    @Test
    void ball이_3일_경우_3을_리턴한다() {
        Guess guess = new Guess("123");
        List<BaseballNumber> answer = baseballNumberList("312");

        assertThat(guess.ballCount(answer)).isEqualTo(3);
    }

    @Test
    void ball이_0일_경우_0을_리턴한다() {
        Guess guess = new Guess("123");
        List<BaseballNumber> answer = baseballNumberList("123");

        assertThat(guess.ballCount(answer)).isEqualTo(0);
    }

    @Test
    void strike가_3일_경우_3을_리턴한다() {
        Guess guess = new Guess("123");
        List<BaseballNumber> answer = baseballNumberList("123");

        assertThat(guess.strikeCount(answer)).isEqualTo(3);
    }

    @Test
    void strike가_0일_경우_0을_리턴한다() {
        Guess guess = new Guess("123");
        List<BaseballNumber> answer = baseballNumberList("312");

        assertThat(guess.strikeCount(answer)).isEqualTo(0);
    }

}