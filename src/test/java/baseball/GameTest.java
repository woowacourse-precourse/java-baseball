package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.model.Answer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {
    Answer answer;

    @BeforeEach()
    void init() {
        answer = new Answer();
    }

    @Test
    void 정답값이_3자리수안지() {
        assertThat(answer.getValue()).size().isEqualTo(3);
    }

    @Test
    void 정답값의_각각의_수가_1에서_9까지_값인지() {
        for (int i = 0; i < 3; i++) {
            assertThat(answer.getValue().get(i)).isBetween(1, 9);
        }
    }

    @Test
    void 정답값의_각각의_수가_중복되지_않는지(){
        assertThat(answer.getValue().stream()
                .distinct()
                .count() != answer.getValue().size()).isEqualTo(false);
    }
}
