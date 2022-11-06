package baseball;

import static baseball.Constants.RANGE_OF_BALL_EXCEPTION;
import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class BaseballGameTest {
    public static BaseballGame game;

    @BeforeAll
    public static void create() {
        game = new BaseballGame();
    }

    @ParameterizedTest
    @DisplayName("낫싱, 볼, 스트라이크 확인")
    @CsvSource(value = {
            "0:0:낫싱",
            "0:1:1볼",
            "1:0:1스트라이크",
            "1:1:1볼 1스트라이크",
            "3:0:3스트라이크"
    }, delimiter = ':')
    void nothing(int ball, int strike, String result) throws Exception {
        Method makeResultMethod = BaseballGame.class.getDeclaredMethod("makeResult", int.class, int.class);
        makeResultMethod.setAccessible(true);

        String actual = (String) makeResultMethod.invoke(game, ball, strike);

        assertThat(actual).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("정답 각 자리의 수가 1 ~ 9가 아닐 때 예외")
    @ValueSource(ints = {0, -1, 10})
    void validateRange(int ball) throws Exception {
        Method validateMethod = BaseballGame.class.getDeclaredMethod("validateRangeOfBall", int.class);
        validateMethod.setAccessible(true);

        try {
            validateMethod.invoke(game, ball);
        } catch (InvocationTargetException e) {
            assertThat(e.getCause().getMessage()).isEqualTo(RANGE_OF_BALL_EXCEPTION);
        }
    }
}
