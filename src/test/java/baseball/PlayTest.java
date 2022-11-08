package baseball;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class PlayTest {

    @Test
    void 중복_없는_세자리_난수_생성() {
        assertThat(Exception.isRedundancy(Play.createThreeNumber())).isFalse();
    }

    @Test
    void 볼_개수_확인() {
        assertThat(Play.countBall("123", "345")).isEqualTo(1);
    }

    @Test
    void 스트라이크_개수_확인() {
        assertThat(Play.countStrike("123", "132")).isEqualTo(1);
    }

    @Test
    void 스트라이크_개수_확인_3스트라이크() {
        assertThat(Play.countStrike("123", "123")).isEqualTo(3);
    }
}
