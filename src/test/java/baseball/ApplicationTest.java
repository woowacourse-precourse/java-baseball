package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    void 중복된_숫자_2개_입력() {
        //given
        String firstMiddleNumber = "112";
        String middleEndNumber = "233";
        String firstEndNumber = "191";

        //when, then
        Assertions.assertThatThrownBy(() -> Application.validateUserNumber(firstMiddleNumber))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UserNumber has duplicate number");
        Assertions.assertThatThrownBy(() -> Application.validateUserNumber(middleEndNumber))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UserNumber has duplicate number");
        Assertions.assertThatThrownBy(() -> Application.validateUserNumber(firstEndNumber))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UserNumber has duplicate number");
    }
    @Test
    void 중복된_숫자_3개_입력() {
        //given
        String givenNumber = "111";
        String givenNumber2 = "222";

        //when, then
        Assertions.assertThatThrownBy(() -> Application.validateUserNumber(givenNumber))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UserNumber has duplicate number");
        Assertions.assertThatThrownBy(() -> Application.validateUserNumber(givenNumber2))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UserNumber has duplicate number");
    }

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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
