package baseball;

import static baseball.Constants.DEFAULT_SIZE;
import static baseball.Constants.RANGE_OF_BALL_EXCEPTION;
import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

    @Test
    @DisplayName("중복되지 않는 볼 추가")
    void addBall() throws Exception {
        Method validateMethod = BaseballGame.class.getDeclaredMethod("addBall", List.class, int.class);
        validateMethod.setAccessible(true);

        List<Integer> list = new ArrayList<>();
        validateMethod.invoke(game, list, 1);
        validateMethod.invoke(game, list, 2);
        validateMethod.invoke(game, list, 3);

        List<Integer> overlapList = new ArrayList<>();
        validateMethod.invoke(game, overlapList, 1);
        validateMethod.invoke(game, overlapList, 2);
        validateMethod.invoke(game, overlapList, 2);

        assertThat(list.size()).isEqualTo(DEFAULT_SIZE);
        assertThat(overlapList.size()).isNotEqualTo(DEFAULT_SIZE);
    }

    @Test
    @DisplayName("컴퓨터 정답 리스트 생성")
    void makeAnswer() throws Exception {
        Method makeMethod = BaseballGame.class.getDeclaredMethod("makeAnswer");
        makeMethod.setAccessible(true);

        List<Integer> answer = (List<Integer>) makeMethod.invoke(game);
        assertThat(answer.size()).isEqualTo(DEFAULT_SIZE);
    }

    @ParameterizedTest
    @DisplayName("컴퓨터 정답 또는 사용자 정답 디폴트 사이즈 체크")
    @CsvSource(value = {
            "-1:false",
            "2:false",
            "3:true",
            "4:false"
    }, delimiter = ':')
    void checkSize(int size, boolean actual) throws Exception {
        Method checkSizeMethod = BaseballGame.class.getDeclaredMethod("isDefaultSize", int.class);
        checkSizeMethod.setAccessible(true);

        assertThat(checkSizeMethod.invoke(game, size)).isEqualTo(actual);
    }
}
