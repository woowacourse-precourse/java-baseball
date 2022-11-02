package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class BaseballGameTest {

    @Test
    void 컴퓨터는_1에서_9사이의_서로_다른_임의의_수_3개를_선택한다() {
        BaseballGame baseballGame = new BaseballGame();

        baseballGame.generate();

        List<Integer> baseballs = baseballGame.getBaseball();
        assertThat(baseballs.stream().distinct().count()).isEqualTo(3);
    }
}
