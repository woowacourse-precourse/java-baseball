package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class AnswerTest {

    List<Integer> init = List.of(1, 2, 3);
    Answer answer = new Answer(init);

    @Test
    void get_메소드는_해당_index의_값을_반환한다() {
        Assertions.assertThat(answer.get(0)).isEqualTo(init.get(0));
    }

    @Test
    void size_메소드는_List의_길이를_반환한다() {
        Assertions.assertThat(answer.size()).isEqualTo(init.size());
    }

}