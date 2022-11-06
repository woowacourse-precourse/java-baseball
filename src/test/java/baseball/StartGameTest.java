package baseball;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class StartGameTest {

    Game game = new Game();

    @Test
    void 메서드_호출시_3개의_서로_다른_수_생성_후_correctAnswer에_반환() {
        game.setComputerAnswer();
        int result = 3;
        Set<Integer> set = new HashSet<>(game.correctAnswer);

        assertThat(game.correctAnswer.size()).isEqualTo(result);
        assertThat(game.correctAnswer.size()).isEqualTo(set.size());
    }


}