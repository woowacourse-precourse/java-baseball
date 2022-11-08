package baseball.domain;

import baseball.vo.ValidationMsg;
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
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ValidationMsg.NUMBER_RANGE_EXCEPTION.getMessage());
    }

    @Test
    void validateNumbersSizeTest() {
        List<Integer> playerNumbers = Arrays.asList(1, 2);
        assertThatThrownBy(() -> new Player(playerNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ValidationMsg.NUMBERS_SIZE_EXCEPTION.getMessage());
    }

    @Test
    void validateDuplicateNumberTest() {
        List<Integer> playerNumbers = Arrays.asList(1, 1, 2);
        assertThatThrownBy(() -> new Player(playerNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ValidationMsg.NUMBER_DUPLICATE_EXCEPTION.getMessage());
    }
}