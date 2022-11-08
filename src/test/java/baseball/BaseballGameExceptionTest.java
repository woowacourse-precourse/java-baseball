package baseball;

import baseball.io.Input;
import baseball.io.option.ReGameOption;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BaseballGameExceptionTest extends NsTest {

    @Test
    void 입력_값이_세_자리가_아니면_InputWrongNumberOfDigitsException_예외가_발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("입력하신 숫자가 3자리가 아닙니다.")
        );
    }

    @Test
    void 입력_값이_숫자가_아니거나_0이_포함되어_있다면_InputNotNumberOrZeroException_예외가_발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a12"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("입력하신 값에 0 혹은 숫자가 아닌 것이 포함되어있습니다.")
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("109"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("입력하신 값에 0 혹은 숫자가 아닌 것이 포함되어있습니다.")
        );
    }

    @Test
    void 입력_값에_중복된_숫자가_있으면_InputSameNumberException_예외가_발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("112"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("입력하신 숫자에 동일한 숫자가 존재합니다.")
        );
    }

    @Test
    void 게임_재시작_여부_입력_값에_잘못된_값이_들어가면_InputWrongReGameNumberException_예외_발생() {
        Input input = new Input();
        assertSimpleTest(() ->
                assertThatThrownBy(() -> ReGameOption.checkValidateOption("0"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("잘못된 숫자를 입력하셨습니다. 1 혹은 2만 입력가능합니다.")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
