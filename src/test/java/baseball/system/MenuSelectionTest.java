package baseball.system;

import baseball.system.progress.MenuSelection;
import org.junit.jupiter.api.Test; // @Test annotation
import org.junit.jupiter.api.BeforeEach; // @BeforeEach annotation

import static org.assertj.core.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import static camp.nextstep.edu.missionutils.test.Assertions.*;

public class MenuSelectionTest extends NsTest {
    //input이 있을 시 사용하는 방법
    private MenuSelection menuSelection;

    @BeforeEach
    private void createObject() {
        menuSelection = new MenuSelection();
    }

    /*
    @Test
    void 입력을_1로_했을_때() { // Expected results : FAILED
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력을_2로_했을_때() { // Expected results : FAILED
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    */

    @Test
    void 입력이_1_또는_2가_아닐_때_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("0"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("입력이 지정된 범위를 벗어났습니다.(1 ~ 2 사이의 값들로 입력)")
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("입력이 지정된 범위를 벗어났습니다.(1 ~ 2 사이의 값들로 입력)")
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("asd"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("입력이 지정된 범위를 벗어났습니다.(1 ~ 2 사이의 값들로 입력)")
        );
    }
    @Override
    protected void runMain() {
        menuSelection.startMenuSelection();
    }
}
