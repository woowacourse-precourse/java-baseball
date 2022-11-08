package baseball;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class ExceptionTest {

    @Test
    void 한자리_난수_중복_검사() {
        assertThat(Exception.isRedundancy("5")).isFalse();
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

    @Test
    void 재시작은_1번() {
        assertThat(Exception.validateCheckPoint("1")).isEqualTo(1);
    }

    @Test
    void 종료는_2번() {
        assertThat(Exception.validateCheckPoint("2")).isEqualTo(2);
    }

    @Test
    void 재시작_혹은_종료_예외_발생() {
        assertThatThrownBy(() ->
                Exception.validateCheckPoint("")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외_테스트_숫자_아님() {
        assertThat(Exception.isException("아무거나")).isTrue();
    }

    @Test
    void 예외_테스트_숫자지만_세자리_아님() {
        assertThat(Exception.isException("3425")).isTrue();
    }

    @Test
    void 예외_테스트_중복된_숫자() {
        assertThat(Exception.isException("233")).isTrue();
    }

    @Test
    void 예외_테스트_통과() {
        assertThat(Exception.isException("123")).isFalse();
    }
}
