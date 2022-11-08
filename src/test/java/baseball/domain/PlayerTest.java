package baseball.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void validateNumberRangeTest() {
        List<Integer> playerNumbers = Arrays.asList(10, 1, 2);
        assertThatThrownBy(() -> new Player(playerNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateNumbersSizeTest() {
        List<Integer> playerNumbers = Arrays.asList(10, 1);
        assertThatThrownBy(() -> new Player(playerNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateDuplicateNumberTest() {
        List<Integer> playerNumbers = Arrays.asList(1, 1, 2);
        assertThatThrownBy(() -> new Player(playerNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}