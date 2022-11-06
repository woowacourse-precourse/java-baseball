package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

public class BaseballTest {
    @Test
    void myThreeNumTest() {
        List<Integer> result = List.of(1, 2, 3);
        assertThat(Application.myThreeNum()).isEqualTo(result);
    }
}
