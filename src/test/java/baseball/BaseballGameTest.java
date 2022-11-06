package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Method;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
}
