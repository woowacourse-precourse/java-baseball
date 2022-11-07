package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

//    @Test
//    void checkUserInput1() {
//        String testString = "766";
//        assertThatThrownBy(() -> Application.checkUserInput(testString))
//                .isInstanceOf(IllegalArgumentException.class);
//    }
//    @Test
//    void checkUserInput2() {
//        String testString = "";
//        assertThatThrownBy(() -> Application.checkUserInput(testString))
//                .isInstanceOf(IllegalArgumentException.class);
//    }

//    @Test
//    void initGame() {
//        for (int i = 0; i < 10; i++) {
//            Application.initGame();
//            System.out.println(Application.answer);
//        }
//    }

    @Test
    void restart() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void exceptionTest1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void exceptionTest2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void exceptionTest3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("14"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void exceptionTest4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("338"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void exceptionTest5() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("jkl2;"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void exceptionTest6() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("3*5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
