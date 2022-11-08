package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class BallNumberTest {

    @ParameterizedTest
    @ValueSource(strings = {"0", "10"})
    void 숫자_입력_범위_초과_BallNumber_객체_생성시_예외_발생(String number) {
        //then

        assertThatThrownBy(() -> new BallNumber(2, number))
                .isExactlyInstanceOf(IllegalArgumentException.class).hasMessage("숫자의 범위가 1~9를 초과하지 않도록 넣어주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "A", "ㅁ", "!", "-"})
    void 문자_입력_BallNumber_객체_생성시_예외_발생(String number) {
        //then

        assertThatThrownBy(() -> new BallNumber(1, number))
                .isExactlyInstanceOf(IllegalArgumentException.class).hasMessage("문자가 아닌 숫자를 넣어주세요.");
    }

    @Test
    void 인덱스_범위_초과_BallNumber_객체_생성시_예외_발생() {
        //then
        assertAll(
                () -> assertThatThrownBy(() -> new BallNumber(3, 1))
                        .isExactlyInstanceOf(IllegalArgumentException.class).hasMessage("3자리의 숫자를 넣어주세요."),
                () -> assertThatThrownBy(() -> new BallNumber(-1, 1))
                        .isExactlyInstanceOf(IllegalArgumentException.class).hasMessage("3자리의 숫자를 넣어주세요.")
        );
    }

    @Test
    void 인덱스_범위_내_BallNumber_객체_생성시_예외_발생X() {
        //then
        assertAll(
                () -> Assertions.assertThatCode(() ->
                        new BallNumber(2, 3)).doesNotThrowAnyException(),
                () -> Assertions.assertThatCode(() ->
                        new BallNumber(0, 1)).doesNotThrowAnyException()
        );
    }
}
