package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class AnswerTest {

    Answer answer = new Answer(List.of(1, 2, 3));

    @Test
    void get_메소드는_해당_index의_값을_반환한다() {
        Assertions.assertThat(answer.get(0)).isEqualTo(1);
    }

}