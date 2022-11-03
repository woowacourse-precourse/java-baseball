package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class BaseBallGameTest {
    @DisplayName("예외 처리 : 입력된 숫자의 길이가 3이 아닌 경우")
    @ParameterizedTest(name = "{displayName} => {0}")
    @ValueSource(strings = {"12", "1234"})
    void exceed_range_exception(String numbers) {
        BaseBallGame baseBallGame = new BaseBallGame();
        
        assertThatIllegalArgumentException()
                .isThrownBy(() -> baseBallGame.play(numbers))
                .withMessage("숫자 3개만 입력할 수 있습니다.");
    }
}