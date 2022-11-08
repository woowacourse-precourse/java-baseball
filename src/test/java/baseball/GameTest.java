package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class GameTest {
    @Test
    void 컴퓨터_랜덤숫자_3자리_테스트() {
        Game game = new Game();
        List<Integer> result = game.pickThreeNumber();
        assertThat(result.size()).isEqualTo(3);
    }

    @Test
    void 컴퓨터_랜덤숫자_범위테스트() {
        Game game = new Game();
        List<Integer> result = game.pickThreeNumber();
        assertThat(result.stream().allMatch(n -> n >= 1 && n <= 9)).isTrue();
    }
}