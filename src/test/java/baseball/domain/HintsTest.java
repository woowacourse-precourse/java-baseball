package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class HintsTest {

    @Test
    void create() {
        Hints actual = new Hints(List.of(Hint.STRIKE, Hint.STRIKE, Hint.BALL));

        assertThat(actual).isEqualTo(new Hints(List.of(Hint.STRIKE, Hint.STRIKE, Hint.BALL)));
    }
}
