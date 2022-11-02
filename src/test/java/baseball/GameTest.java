package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class GameTest {
    @Test
    void 컴퓨터_3자리_숫자_정하기() {
        List<Integer> result = Game.pickThreeNumber();
        Assertions.assertThat(result.size()).isEqualTo(3);
    }
}