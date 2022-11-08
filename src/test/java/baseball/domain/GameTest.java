package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class GameTest {
    @Test
    void 올바른_난수_생성_확인() {
        Game game = new Game();
        List<Integer> randomNumber = game.getAnswer();

        assertThat(randomNumber.size()).isEqualTo(3);
        assertThat(randomNumber.get(0)).isBetween(1, 9);
        assertThat(randomNumber.get(1)).isBetween(1, 9);
        assertThat(randomNumber.get(2)).isBetween(1, 9);

        assertThat(randomNumber.get(0)).isNotEqualTo(randomNumber.get(1));
        assertThat(randomNumber.get(1)).isNotEqualTo(randomNumber.get(2));
        assertThat(randomNumber.get(2)).isNotEqualTo(randomNumber.get(0));
    }
}