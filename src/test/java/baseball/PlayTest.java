package baseball;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class PlayTest {

    @Test
    void 중복_없는_세자리_난수_생성() {
        assertThat(Exception.isRedundancy(Play.createThreeNumber())).isFalse();
    }
}
