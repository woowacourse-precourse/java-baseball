package baseball;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class ExceptionTest {

    @Test
    void 한자리_난수_중복_검사_1부터_9사이() {
        assertThat(Exception.isRedundancy(9)).isFalse();
    }
    @Test
    void 한자리_난수_중복_검사_0() {
        assertThat(Exception.isRedundancy(0)).isFalse();
    }
    @Test
    void 두자리_난수_중복_있음() {
        assertThat(Exception.isRedundancy(22)).isTrue();
    }
    @Test
    void 두자리_난수_중복_없음() {
        assertThat(Exception.isRedundancy(98)).isFalse();
    }
    @Test
    void 세자리_난수_중복_있음() {
        assertThat(Exception.isRedundancy(233)).isTrue();
    }
    @Test
    void 세자리_난수_중복_없음() {
        assertThat(Exception.isRedundancy(329)).isFalse();
    }
}
