package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    public void noticeStartGame_실행_시_숫자_야구_게임_시작_출력에_대한_테스트() throws Exception {
        //reflection
        Method method = Application.class.getDeclaredMethod("noticeStartGame");
        method.setAccessible(true);

        //given
        final String message = "숫자 야구 게임을 시작합니다.\n";

        //when
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        method.invoke(new Application());

        //then
        assertThat(out.toString()).isEqualTo(message);
    }

    @Test
    public void createComputerNumbers_반환하는_리스트_사이즈_3인지에_대한_테스트() throws Exception {
        //reflection
        Method method = Application.class.getDeclaredMethod("createComputerNumbers");
        method.setAccessible(true);

        //given
        final int listSize = 3;

        //when
        List<Integer> invoke = (List<Integer>)method.invoke(new Application());

        //then
        assertThat(invoke.size()).isEqualTo(listSize);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}