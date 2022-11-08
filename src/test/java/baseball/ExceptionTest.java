package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

public class ExceptionTest {

    Exception exception = new Exception();

    @Test
    void 숫자입력3개_정상() {
        assertThatCode(() -> exception.createNumberInputException("123"))
                .doesNotThrowAnyException();
    }

    @Test
    void 숫자입력3객_0입력() {
        assertThatThrownBy(() -> exception.createNumberInputException("012"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자입력3개_중복() {
        assertThatThrownBy(() -> exception.createNumberInputException("112"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자입력_2개() {
        assertThatThrownBy(() -> exception.createNumberInputException("12"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자입력3개_3개가아님() {
        assertThatThrownBy(() -> exception.createNumberInputException("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자입력3개_숫자가아님() {
        assertThatThrownBy(() -> exception.createNumberInputException("12a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void GameRestart_1_입력() {
        assertThatCode(() -> exception.restartException(1))
                .doesNotThrowAnyException();
    }

    @Test
    void GameRestart_2_입력() {

        assertThatCode(() -> exception.restartException(2))
                .doesNotThrowAnyException();
    }

    @Test
    void GameRestart_3_입력() {

        assertThatThrownBy(() -> exception.restartException(3))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
