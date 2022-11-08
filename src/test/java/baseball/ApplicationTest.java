package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
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
    void 세개의_숫자가_아닌_경우_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234", "12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 스트라이크_개수_검증_테스트() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Application application = new Application();
        
        List<Integer> computer = new ArrayList<>();
        List<Integer> player = new ArrayList<>();

        computer.add(1);
        computer.add(2);
        computer.add(3);

        player.add(1);
        player.add(2);
        player.add(5);

        Method countStrike = application.getClass().getDeclaredMethod("countStrike", List.class, List.class);
        countStrike.setAccessible(true);

        int strike = (int)countStrike.invoke(application, computer, player);

        assertThat(strike).isEqualTo(2);
    }

    @Test
    void 볼_개수_검증_테스트() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Application application = new Application();

        List<Integer> computer = new ArrayList<>();
        List<Integer> player = new ArrayList<>();

        computer.add(1);
        computer.add(2);
        computer.add(3);

        player.add(1);
        player.add(5);
        player.add(2);

        Method countBall = application.getClass().getDeclaredMethod("countBall", List.class, List.class);
        countBall.setAccessible(true);

        int ball = (int)countBall.invoke(application, computer, player);

        assertThat(ball).isEqualTo(1);
    }

    @Test
    void 입력_결과_검증_테스트() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Application application = new Application();

        List<Integer> computer = new ArrayList<>();
        List<Integer> player = new ArrayList<>();

        computer.add(1);
        computer.add(2);
        computer.add(3);

        player.add(1);
        player.add(5);
        player.add(2);

        Method countStrike = application.getClass().getDeclaredMethod("countStrike", List.class, List.class);
        countStrike.setAccessible(true);

        Method countBall = application.getClass().getDeclaredMethod("countBall", List.class, List.class);
        countBall.setAccessible(true);

        Method makeHint = application.getClass().getDeclaredMethod("makeHint", int.class, int.class);
        makeHint.setAccessible(true);

        int strike = (int)countStrike.invoke(application, computer, player);
        int ball = (int)countBall.invoke(application, computer, player);

        String result = (String) makeHint.invoke(application, strike, ball);

        assertThat(result).isEqualTo("1볼 1스트라이크");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
