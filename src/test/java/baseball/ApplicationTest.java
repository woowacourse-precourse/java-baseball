package baseball;

import baseball.constant.MessageConst;
import baseball.validation.InputValidation;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class ApplicationTest extends NsTest {
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("사용자의 입력값 길이 테스트")
    void 사용자_입력_길이_테스트() {
        // given
        InputValidation inputValidation = new InputValidation();

        // when
        String userCorrectInput = "123";
        String userLessInput = "12";
        String userMoreInput = "1234";

        // then
        assertThatCode(() ->
                inputValidation.validateInputLength(userCorrectInput))
                .doesNotThrowAnyException();

        assertThatThrownBy(() ->
                inputValidation.validateInputLength(userLessInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MessageConst.INPUT_LENGTH_EXCEPTION_MSG);

        assertThatThrownBy(() ->
                inputValidation.validateInputLength(userMoreInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MessageConst.INPUT_LENGTH_EXCEPTION_MSG);
    }

    @Test
    @DisplayName("사용자의 입력값 범위 테스트")
    void 사용자_입력_범위_테스트() {
        // given
        InputValidation inputValidation = new InputValidation();
        List<Integer> userCorrectInput = new ArrayList<>();
        List<Integer> userWrongInput = new ArrayList<>();

        // when
        userCorrectInput.add(1);
        userCorrectInput.add(2);
        userCorrectInput.add(3);

        userWrongInput.add(0);
        userWrongInput.add(1);
        userWrongInput.add(2);

        // then
        assertThatCode(() ->
                inputValidation.validateInputRange(userCorrectInput))
                .doesNotThrowAnyException();

        assertThatThrownBy(() ->
                inputValidation.validateInputRange(userWrongInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MessageConst.INPUT_RANGE_EXCEPTION_MSG);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
