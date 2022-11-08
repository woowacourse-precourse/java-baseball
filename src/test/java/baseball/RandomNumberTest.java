package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberTest {

    @Test
    @DisplayName("랜덤숫자 테스트")
    void 랜덤_숫자_테스트() {
        Game game = new Game();
        assertThat(game.validateAnswer_number()).isEqualTo(true);
    }

}
