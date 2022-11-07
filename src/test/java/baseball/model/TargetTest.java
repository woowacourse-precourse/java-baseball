package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TargetTest {
    private Target target = new Target();

    @BeforeEach
    void initTarget() {
        target.setTargetIntoZeroList();
    }

    @Test
    void reset() {
        target.reset();
        assertThat(target.get())
                .hasSize(3)
                .doesNotContain(0);
    }

    @Test
    void get() {
        target.reset();
        target.setTargetIntoZeroList();
        List<Integer> result = Arrays.asList(0, 0, 0);
        assertThat(target.get()).isEqualTo(result);
    }

    @Test
    void setOneNumber() {
        target.setOneNumber(1);
        List<Integer> targetNumberList = target.get();
        assertThat(targetNumberList.get(1)).isNotEqualTo(0);
        assertThat(targetNumberList.get(0)).isEqualTo(0);
    }
}
