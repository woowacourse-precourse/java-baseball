package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest {

    @DisplayName("플레이어의 난수 유효성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"24", "1213", "1234"})
    public void player_number_count_check(String input) {
        assertThatThrownBy(() -> {
            Player.checkInputSize(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("플레이어의 입력 중 중복이 있는지 테스트")
    @Test
    public void player_number_duplicate_check() {
        assertThatThrownBy(() -> Player.isDuplicated("665")).isInstanceOf(IllegalArgumentException.class);
    }
}
