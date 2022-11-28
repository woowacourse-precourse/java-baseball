package baseball;

import baseball.model.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Nested
@DisplayName("플레이어 수 검증")
public class PlayerTest {

    @Test
    @DisplayName("올바른 입력값")
    void rightPlayer() {
        Player player = new Player("123");
        assertThat(player.get()).isEqualTo(List.of(1, 2, 3));
    }

    @ParameterizedTest
    @ValueSource(strings = {"012", "1234", "334", "sd3"})
    @DisplayName("잘못된 입력값(플레이어의 수) 예외 테스트")
    void wrongPlayer(String input) {
        assertThatThrownBy(() -> new Player(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
