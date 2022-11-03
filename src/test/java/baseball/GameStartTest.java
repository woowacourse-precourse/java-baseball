package baseball;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class GameStartTest {

    Game game = new Game();

    @Test
    void 길이가_3인_정답_생성() {
        game.start();
        int result = 3;
        assertThat(game.correctAnswer.size()).isEqualTo(result);
    }

    @Test
    void 중복_없음() {
        game.start();
        Set<Integer> set = new HashSet<>(game.correctAnswer);

        assertThat(game.correctAnswer.size()).isEqualTo(set.size());
    }

}