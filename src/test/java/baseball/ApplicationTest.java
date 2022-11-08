package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.*;
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

    @Test
    public void createComputerNumbers_생성하는_숫자_1부터_9까지_범위_테스트() throws Exception {
        //reflection
        Method method = Application.class.getDeclaredMethod("createComputerNumbers");
        method.setAccessible(true);

        List<Integer> invoke = (List<Integer>)method.invoke(new Application());
        int first = invoke.get(0);
        int second = invoke.get(1);
        int third = invoke.get(2);

        assertThat(first).isLessThan(10);
        assertThat(second).isLessThan(10);
        assertThat(third).isLessThan(10);
        assertThat(first).isGreaterThan(0);
        assertThat(second).isGreaterThan(0);
        assertThat(third).isGreaterThan(0);
    }

    @Test
    public void isValidUserNumbers_입력의_유효성_검증_테스트() throws Exception {
        //reflection
        Method method = Application.class.getDeclaredMethod("isValidUserNumbers", String.class);
        method.setAccessible(true);

        //given
        String firstNumbers = "144";
        String secondNumbers = "143";
        String thirdNumbers = "054";

        //when
        boolean firstResult = (boolean)method.invoke(new Application(), firstNumbers);
        boolean secondResult = (boolean)method.invoke(new Application(), secondNumbers);
        boolean thirdResult = (boolean)method.invoke(new Application(), thirdNumbers);

        //then
        assertThat(firstResult).isEqualTo(false);
        assertThat(secondResult).isEqualTo(true);
        assertThat(thirdResult).isEqualTo(false);
    }

    @Test
    public void inputUserNumbers_입력에_관한_문구_정상_출력_테스트() throws Exception {
        //reflection
        Method method = Application.class.getDeclaredMethod("inputUserNumbers");
        method.setAccessible(true);

        //given
        final String message = "숫자를 입력해주세요 : ";

        //when
        InputStream sysInBackup = System.in; // System.in을 원래대로 복구하기 위해 선언
        ByteArrayInputStream in = new ByteArrayInputStream("123".getBytes());
        System.setIn(in);
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        method.invoke(new Application());

        //then
        assertThat(out.toString()).isEqualTo(message);
        System.setIn(sysInBackup);
    }

    @Test
    public void getBallNumber_볼의_개수에_대한_테스트() throws Exception {
        //reflection
        Method method = Application.class.getDeclaredMethod("getBallNumber", List.class, String.class);
        method.setAccessible(true);

        //given
        List<Integer> givenComputerNumbers = List.of(9, 5, 3);
        String givenUserNumbers = "593";
        int expected = 2;

        //when
        int invoke = (int)method.invoke(new Application(), givenComputerNumbers, givenUserNumbers);

        //then
        assertThat(invoke).isEqualTo(expected);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}