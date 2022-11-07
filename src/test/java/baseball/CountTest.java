package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CountTest {
    private final List<Integer> opponent = List.of(1, 4, 3);
    private final List<Integer> user = List.of(3, 4, 7);

    @Test
    void countStrikes() {
        int strikeCount = 1;
        assertThat(Count.Strike(opponent, user)).isEqualTo(strikeCount);
    }

}
