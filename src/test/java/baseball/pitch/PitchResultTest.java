package baseball.pitch;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PitchResultTest {
    @Test
    void ball과_strike가_둘다_0일_때_낫싱() {
        PitchResult pitchResult = new PitchResult(0, 0);
        assertThat(pitchResult.getPitchResultString()).isEqualTo("낫싱");
    }

    @Test
    void ball이_1이고_stike가_0일_때_1볼() {
        PitchResult pitchResult = new PitchResult(1, 0);
        assertThat(pitchResult.getPitchResultString()).isEqualTo("1볼");
    }
}
