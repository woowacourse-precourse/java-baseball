package baseball.input;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameInputTest {
    @Test
    @DisplayName("서로 다른 3자릿수가 제대로 저장된다.")
    public void uniqueDigit() {
        GameInput input = new GameInput(123);
        assertThat(input.first).isEqualTo(1);
        assertThat(input.second).isEqualTo(2);
        assertThat(input.third).isEqualTo(3);
    }
}