package baseball.pitch;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PitchResultTest {
    @Test
    void 낫싱() {
        PitchResult pitchResult = new PitchResult(0, 0);
        assertThat(pitchResult.getPitchResultString()).isEqualTo("낫싱");
    }
}
