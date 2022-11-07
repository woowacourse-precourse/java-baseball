package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TargetTest {
    @Test
    void reset() {
        Target.reset();
        assertThat(Target.get())
                .hasSize(3)
                .doesNotContain(0);
    }

    @Test
    void get() {
        Target.setTargetIntoZeroList();
        List<Integer> result = Arrays.asList(0, 0, 0);
        assertThat(Target.get()).isEqualTo(result);
    }
}
