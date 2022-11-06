package baseball;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    @Test
    void initAnswer_무작위_세자리_수_세팅() {
        Game game = new Game(new Player(), new Referee());
        game.initAnswer();
        List<Integer> answer = game.getAnswer();
        assertThat(answer).hasSize(3);
    }

    @Test
    void initAnswer_중복숫자가_없어야_함() {
        for (int i = 0; i < 100; i++) {
            Game game = new Game(new Player(), new Referee());
            game.initAnswer();
            List<Integer> answer = game.getAnswer();
            assertThat(isUnique(answer)).isTrue();
        }
    }

    private boolean isUnique(List<Integer> answer) {
        return answer.size() == new HashSet<>(answer).size();
    }
}
