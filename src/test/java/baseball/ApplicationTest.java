package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
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
    void 리스트_변환_테스트() throws Exception {
        //given
        Computer computer = new Computer();
        Game game = new Game(computer);
        Method method = game.getClass().getDeclaredMethod("stringToIntegerList",String.class);
        method.setAccessible(true);

        //when
        List<Integer> test = (List<Integer>) method.invoke(game,"123");

        //then
        assertThat(test.get(0)).isEqualTo(1);
    }

    @Test
    void 난수_유효성검증_테스트() throws Exception{
        //given
        Computer computer = new Computer();
        Method method = computer.getClass().getDeclaredMethod("isValidateNumber",List.class);
        method.setAccessible(true);
        //when

        List<Integer> test = new ArrayList<>();
        boolean firstTest;
        test.add(0);
        test.add(2);
        test.add(3);

        firstTest = (boolean) method.invoke(computer, test);

        List<Integer> test2 = new ArrayList<>();
        boolean secondTest;
        test2.add(1);
        test2.add(2);
        test2.add(3);
        test2.add(4);

        secondTest = (boolean) method.invoke(computer, test2);

        //then
        assertThat(firstTest).isEqualTo(false);
        assertThat(secondTest).isEqualTo(false);
    }

    @Test
    void 사용자_입력검증_테스트() {
        //given
        Computer computer = new Computer();
        Game game = new Game(computer);
        //when
        String test = "*()";
        String test2 = "123";
        //then
        assertThatThrownBy(() -> game.validateUserInput(test))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input is wrong.");

        assertThatCode(() -> game.validateUserInput(test2))
                .doesNotThrowAnyException();

    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
