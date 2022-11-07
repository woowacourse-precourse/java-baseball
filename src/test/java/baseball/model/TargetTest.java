package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TargetTest {
    @BeforeEach
    void initTarget() {
        Target.setTargetIntoZeroList();
    }

    @Test
    void reset() {
        Target.reset();
        assertThat(Target.get())
                .hasSize(3)
                .doesNotContain(0);
    }

    @Test
    void get() {
        Target.reset();
        Target.setTargetIntoZeroList();
        List<Integer> result = Arrays.asList(0, 0, 0);
        assertThat(Target.get()).isEqualTo(result);
    }

    @Test
    void setOneNumber() {
        Target.setOneNumber(1);
        List<Integer> targetNumberList = Target.get();
        assertThat(targetNumberList.get(1)).isNotEqualTo(0);
        assertThat(targetNumberList.get(0)).isEqualTo(0);
    }
}
