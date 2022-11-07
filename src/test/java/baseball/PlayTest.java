package baseball;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class PlayTest {

    @Test
    void 난수_생성() {
        assertThat(Play.createThreeNumber()).isIn(1, 2, 3, 4, 5, 6, 7, 8, 9);
    }
}
