package baseball.component;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BaseballGameControllerTest extends NsTest {

    @Test
    @DisplayName("예외_테스트 - player number 2자리 수 입력")
    void playerNumber2digitTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("13"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("[ERROR] 0이아닌 서로 다른 3자리 수를 입력하세요.")
        );
    }

    @Test
    @DisplayName("예외_테스트 - player number 숫자가 아닌 문자 입력")
    void playerNumberNotNumberTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("[ERROR] 0이아닌 서로 다른 3자리 수를 입력하세요.")
        );
    }

    @Test
    @DisplayName("예외_테스트 - player number 중복되는 수 입력1 - abb")
    void duplicatedExceptionTest1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("122"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("[ERROR] 0이아닌 서로 다른 3자리 수를 입력하세요.")
        );
    }

    @Test
    @DisplayName("예외_테스트 - player number 중복되는 수 입력2 - aab")
    void duplicatedExceptionTest2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("332"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("[ERROR] 0이아닌 서로 다른 3자리 수를 입력하세요.")
        );
    }

    @Test
    @DisplayName("예외_테스트 - player number 중복되는 수 입력3 - aba")
    void duplicatedExceptionTest3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("383"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("[ERROR] 0이아닌 서로 다른 3자리 수를 입력하세요.")
        );
    }

    @Test
    @DisplayName("예외_테스트 - player number 중복되는 수 입력4 - aaa")
    void duplicatedExceptionTest4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("777"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("[ERROR] 0이아닌 서로 다른 3자리 수를 입력하세요.")
        );
    }

    @Override
    protected void runMain() {
        BaseballGameController baseballGameController = new BaseballGameController();
        baseballGameController.startGame();
    }
}