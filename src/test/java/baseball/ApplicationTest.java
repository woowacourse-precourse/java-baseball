package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.util.List;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

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
    void 예외_테스트1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1a3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    List<Integer> getThreeRandomNumbers() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object ret;
        Class app = Application.class;
        Method method = app.getDeclaredMethod("generateThreeRandomNumber");

        method.setAccessible(true);
        ret = method.invoke(null);
        return (List<Integer>) ret;
    }

    @Test
    void 중복된_랜덤_값_발생_테스트1() {
        assertRandomNumberInRangeTest(
                () -> {
                    List<Integer> result = List.of(1,3,5);
                    assertThat(getThreeRandomNumbers()).isEqualTo(result);
                },
                1, 3, 3, 3, 5
        );
    }

    @Test
    void 중복된_랜덤_값_발생_테스트2() {
        assertRandomNumberInRangeTest(
                () -> {
                    List<Integer> result = List.of(3,5,1);
                    assertThat(getThreeRandomNumbers()).isEqualTo(result);
                },
                3, 3, 3, 3, 5, 1
        );
    }

    @Test
    void 사용자_중복_입력_예외_테스트1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("122"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 사용자_중복_입력_예외_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("333"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 사용자_재시작_입력_예외_테스트1() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("135", "3"))
                            .isInstanceOf(IllegalArgumentException.class);
                    },
                1, 3, 5
        );
    }

    @Test
    void 사용자_재시작_입력_예외_테스트2() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("135", "0"))
                            .isInstanceOf(IllegalArgumentException.class);
                    },
                1, 3, 5
        );
    }

    @Test
    void 사용자_재시작_입력_예외_테스트3() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("135", "a"))
                            .isInstanceOf(IllegalArgumentException.class);
                    },
                1, 3, 5
        );
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
