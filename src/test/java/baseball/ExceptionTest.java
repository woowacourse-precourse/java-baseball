package baseball;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class ExceptionTest {

    @Test
    void 한자리_난수_중복_검사() {
        assertThat(Exception.isRedundancy("6")).isFalse();
    }
    @Test
    void 두자리_난수_중복_있음() {
        assertThat(Exception.isRedundancy("22")).isTrue();
    }
    @Test
    void 두자리_난수_중복_없음() {
        assertThat(Exception.isRedundancy("98")).isFalse();
    }
    @Test
    void 세자리_난수_중복_있음() {
        assertThat(Exception.isRedundancy("233")).isTrue();
    }
    @Test
    void 세자리_난수_중복_없음() {
        assertThat(Exception.isRedundancy("329")).isFalse();
    }
    @Test
    void 숫자만_입력() {
        assertThat(Exception.isNumber("329")).isTrue();
    }
    @Test
    void 문자를_입력() {
        assertThat(Exception.isNumber("문자3")).isFalse();
    }
    @Test
    void 세자리_숫자() {
        assertThat(Exception.isThreeNumber("324")).isTrue();
    }
    @Test
    void 세자리_미만_숫자() {
        assertThat(Exception.isThreeNumber("24")).isFalse();
    }
    @Test
    void 세자리_초과_숫자() {
        assertThat(Exception.isThreeNumber("2433")).isFalse();
    }
}
