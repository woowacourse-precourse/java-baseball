package baseball;

import baseball.Number.CheckInputNumberException;
import baseball.game.CheckRestartNumberException;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MyExceptionTest {
    @Test
    void inputNumber예외_중복숫자입력(){
        CheckInputNumberException checkInputNumberException = new CheckInputNumberException();
        assertSimpleTest(() ->
                assertThatThrownBy(() -> checkInputNumberException.checkException("112"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void inputNumber예외_문자입력(){
        CheckInputNumberException checkInputNumberException = new CheckInputNumberException();
        assertSimpleTest(() ->
                assertThatThrownBy(() -> checkInputNumberException.checkException("12a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void inputNumber예외_3자리수가아닌_입력(){
        CheckInputNumberException checkInputNumberException = new CheckInputNumberException();
        assertSimpleTest(() ->
                assertThatThrownBy(() -> checkInputNumberException.checkException("12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> checkInputNumberException.checkException("789456"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void reStartNumber예외_1과2가아닌_입력() {
        CheckRestartNumberException checkRestartNumberException = new CheckRestartNumberException();
        assertSimpleTest(() ->
                assertThatThrownBy(() -> checkRestartNumberException.checkException("3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> checkRestartNumberException.checkException("a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

    }
}
