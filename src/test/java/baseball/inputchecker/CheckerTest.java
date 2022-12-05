package baseball.inputchecker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CheckerTest {
    @Test
    void 정상값입력(){
        Checker.isValid("123");
        Checker.isValid("139");
        Checker.isValid("327");
    }
    @Test
    void 예외값입력() {
        assertThatThrownBy(() -> Checker.isValid("a1234")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Checker.isValid("a123")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Checker.isValid("1223")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Checker.isValid("122")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Checker.isValid("992")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Checker.isValid("92")).isInstanceOf(IllegalArgumentException.class);
    }
}