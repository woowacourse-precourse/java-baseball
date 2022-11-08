package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class AnswerTest {

    private final Answer answer = new Answer();

    @Test
    void generateAnswer_정답_길이_확인() {
        int length = 3;

        assertThat(answer.generateAnswer().size()).isEqualTo(length);
    }
}
