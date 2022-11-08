package baseball;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

class BaseballInputTest extends NsTest {
    byte[] command(String arg) {
        return arg.getBytes();
    }

    @Test
    void 유저가_숫자를_적게_입력하면_예외_발생() {
        String arg = "12";
        final byte[] buf = command(arg);
        System.setIn(new ByteArrayInputStream(buf));

        assertThatThrownBy(BaseballInput::getUserNumber)
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 유저가_공백이_포함된_숫자를_입력하면_예외_발생() {
        String arg = "1 2 3";
        final byte[] buf = command(arg);
        System.setIn(new ByteArrayInputStream(buf));

        assertThatThrownBy(BaseballInput::getUserNumber)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 유저가_숫자를_많게_입력하면_예외_발생() {
        String arg = "12";
        final byte[] buf = command(arg);
        System.setIn(new ByteArrayInputStream(buf));

        assertThatThrownBy(BaseballInput::getUserNumber)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 유저가_중복된_숫자를_입력하면_예외_발생() {
        String arg = "112";
        final byte[] buf = command(arg);
        System.setIn(new ByteArrayInputStream(buf));

        assertThatThrownBy(BaseballInput::getUserNumber)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 유저가_숫자가_아닌_글자를_입력하면_예외_발생() {
        String arg = "a12";
        final byte[] buf = command(arg);
        System.setIn(new ByteArrayInputStream(buf));

        assertThatThrownBy(BaseballInput::getUserNumber)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 유저가_플레이_코드가_아닌_수를_입력하면_예외_발생() {
        String arg = "3";
        final byte[] buf = command(arg);
        System.setIn(new ByteArrayInputStream(buf));

        assertThatThrownBy(BaseballInput::getPlayCode)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    protected void runMain() {

    }


}
