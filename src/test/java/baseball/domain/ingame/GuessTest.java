package baseball.domain.ingame;

import static baseball.domain.baseballnumber.BaseballNumberListGenerator.baseballNumberList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.domain.baseballnumber.BaseballNumber;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GuessTest {

    @ParameterizedTest(name = "중복 숫자를 입력하면 예외를 던진다")
    @ValueSource(strings = {"112", "111"})
    void duplicationTest(String inputValue) {
        assertThatThrownBy(() -> new Guess(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복 숫자는 입력할 수 없습니다.");
    }

    @ParameterizedTest(name = "세 자리가 아닌 문자열을 입력받으면 예외를 던진다")
    @ValueSource(strings = {"1234", "12"})
    void threeNumberTest(String inputValue) {
        assertThatThrownBy(() -> new Guess(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("세자리의 숫자를 입력해 주세요.");
    }

    @DisplayName("ball이 3일 경우 3을 리턴한다")
    @Test
    void ThreeBallTest() {
        Guess guess = new Guess("123");
        List<BaseballNumber> answer = baseballNumberList("312");

        assertThat(guess.ballCount(answer)).isEqualTo(3);
    }

    @DisplayName("ball이 0일 경우 0을 리턴한다")
    @Test
    void zeroBallTest() {
        Guess guess = new Guess("123");
        List<BaseballNumber> answer = baseballNumberList("123");

        assertThat(guess.ballCount(answer)).isEqualTo(0);
    }

    @DisplayName("strike가 3일 경우 3을 리턴한다")
    @Test
    void threeStrikeTest() {
        Guess guess = new Guess("123");
        List<BaseballNumber> answer = baseballNumberList("123");

        assertThat(guess.strikeCount(answer)).isEqualTo(3);
    }

    @DisplayName("strike가 0일 경우 0을 리턴한다")
    @Test
    void zeroStrikeTest() {
        Guess guess = new Guess("123");
        List<BaseballNumber> answer = baseballNumberList("312");

        assertThat(guess.strikeCount(answer)).isEqualTo(0);
    }
}