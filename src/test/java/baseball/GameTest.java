package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    void setAnswer_메서드_사용하면_answer가_서로_다른_3자리의_1에서_9의_숫자로_설정() {
        Game game = new Game();
        game.setAnswer();
        List<Integer> answer = game.getAnswer();
        Set<Integer> numberSet = new HashSet<>(answer);

        assertAll(
                () -> assertThat(answer.size()).isEqualTo(3),
                () -> assertThat(numberSet.size()).isEqualTo(3),
                () -> assertThat(answer).allMatch(number -> number >= 1 && number <= 9)
        );
    }
}
