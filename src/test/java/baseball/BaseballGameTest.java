package baseball;

import static baseball.Constants.DEFAULT_SIZE;
import static baseball.Constants.INPUT_LENGTH_EXCEPTION;
import static baseball.Constants.INPUT_OTHER_NUMBER_EXCEPTION;
import static baseball.Constants.NUMBER_FORMAT_EXCEPTION;
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
        Method checkSizeMethod = BaseballGame.class.getDeclaredMethod("isNotDefaultSize", int.class);
        checkSizeMethod.setAccessible(true);

        assertThat(checkSizeMethod.invoke(game, size)).isEqualTo(actual);
    }

    @Test
    @DisplayName("사용자 입력 시 정답 리스트 생성")
    void makeUserList() throws Exception {
        Method makeMethod = BaseballGame.class.getDeclaredMethod("makeUserList", String.class);
        makeMethod.setAccessible(true);

        List<Integer> actual = (List<Integer>) makeMethod.invoke(game, "123");
        assertThat(actual).isEqualTo(List.of(1, 2, 3));
    }

    @ParameterizedTest
    @DisplayName("사용자가 세자리를 입력하지 않았을 때 예외")
    @ValueSource(strings = {"12", "", "1234", "  "})
    void validateUserInputLength(String input) throws Exception {
        Method validMethod = BaseballGame.class.getDeclaredMethod("makeUserAnswer", String.class);
        validMethod.setAccessible(true);

        try {
            validMethod.invoke(game, input);
        } catch (InvocationTargetException e) {
            assertThat(e.getCause().getMessage()).isEqualTo(INPUT_LENGTH_EXCEPTION);
        }
    }

    @ParameterizedTest
    @DisplayName("사용자가 중복된 수를 입력했을 때 예외")
    @ValueSource(strings = {"122", "111", "331"})
    void validateOverlapUserInput(String input) throws Exception {
        Method validMethod = BaseballGame.class.getDeclaredMethod("makeUserAnswer", String.class);
        validMethod.setAccessible(true);

        try {
            validMethod.invoke(game, input);
        } catch (InvocationTargetException e) {
            assertThat(e.getCause().getMessage()).isEqualTo(INPUT_OTHER_NUMBER_EXCEPTION);
        }
    }

    @ParameterizedTest
    @DisplayName("사용자가 문자를 입력했을 때 예외")
    @ValueSource(strings = {"a12", "bbb", "12a", "   "})
    void validateNumberOfUserInput(String input) throws Exception {
        Method validMethod = BaseballGame.class.getDeclaredMethod("makeUserAnswer", String.class);
        validMethod.setAccessible(true);

        try {
            validMethod.invoke(game, input);
        } catch (InvocationTargetException e) {
            assertThat(e.getCause().getMessage()).isEqualTo(NUMBER_FORMAT_EXCEPTION);
        }
    }

    @Test
    @DisplayName("스트라이크 테스트")
    void strike() throws Exception {
        Method strikeMethod = BaseballGame.class.getDeclaredMethod("strike", List.class, List.class, int.class,
                int.class);
        strikeMethod.setAccessible(true);

        List<Integer> answer = List.of(1, 2, 3);
        List<Integer> user = List.of(1, 4, 5);

        int strike = 0;
        for (int i = 0; i < DEFAULT_SIZE; i++) {
            strike = (int) strikeMethod.invoke(game, answer, user, strike, i);
        }
        assertThat(strike).isEqualTo(1);
    }

    @Test
    @DisplayName("볼 테스트")
    void ball() throws Exception {
        Method strikeMethod = BaseballGame.class.getDeclaredMethod("ball", List.class, List.class, int.class,
                int.class);
        strikeMethod.setAccessible(true);

        List<Integer> answer = List.of(1, 2, 3);
        List<Integer> user = List.of(5, 4, 1);

        int ball = 0;
        for (int i = 0; i < DEFAULT_SIZE; i++) {
            ball = (int) strikeMethod.invoke(game, answer, user, ball, i);
        }
        assertThat(ball).isEqualTo(1);
    }
}
