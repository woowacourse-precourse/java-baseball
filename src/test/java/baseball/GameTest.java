package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameTest extends NsTest {
    /* 게임 진행 부분 Test */
    @Test
    void gameRunning_Test() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }


    /* 게임 3자리 숫자 Input 부분 Test */
    @Test
    void Exception_Test_ThreeNumberInput_LengthInput() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("123445612345"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void Exception_Test_ThreeNumberInput_LengthInput2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("123 "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void Exception_Test_ThreeNumberInput_LengthInput3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" 123"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void Exception_Test_ThreeNumberInput_DuplicateInput() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("111"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void Exception_Test_ThreeNumberInput_DuplicateInput2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("991"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void Exception_Test_ThreeNumberInput_DuplicateInput3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("262"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void Exception_Test_ThreeNumberInput_NotRangeInput1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("078"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void Exception_Test_ThreeNumberInput_NotRangeInput2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("840"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void Exception_Test_ThreeNumberInput_NotRangeInput3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("+-/"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    /* 게임 재시작 Input 부분 Test */
    @Test
    void Exception_Test_RestartInput1() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("486", "22"))
                            .isInstanceOf(IllegalArgumentException.class);
                },
                4, 8, 6
        );
    }

    @Test
    void Exception_Test_RestartInput2() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("486", "0"))
                            .isInstanceOf(IllegalArgumentException.class);
                },
                4, 8, 6
        );
    }

    @Test
    void Exception_Test_RestartInput3() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("486", "*"))
                            .isInstanceOf(IllegalArgumentException.class);
                },
                4, 8, 6
        );
    }
    @Test
    void Exception_Test_RestartInput4() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("486", "123"))
                            .isInstanceOf(IllegalArgumentException.class);
                },
                4, 8, 6
        );
    }




    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
