package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    Application application = new Application();
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
    void 프로그램_시작_출력_테스트() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Method printProgramStart = Application.class.getDeclaredMethod("printProgramStart");
        printProgramStart.setAccessible(true);
        
        printProgramStart.invoke(application);

        assertThat(output()).isEqualTo("숫자 야구 게임을 시작합니다.");
    }

    @Test
    void 게임종료_출력_테스트() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Method printGameEnd = Application.class.getDeclaredMethod("printGameEnd");
        printGameEnd.setAccessible(true);

        printGameEnd.invoke(application);

        assertThat(output()).isEqualTo("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
