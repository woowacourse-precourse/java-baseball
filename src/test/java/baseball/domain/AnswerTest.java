package baseball.domain;

import baseball.utils.BaseBallStatus;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class AnswerTest {

    List<Integer> init = List.of(1, 2, 3);
    Answer answer = new Answer(init);

    // 기본 길이
    BaseBallStatus status = BaseBallStatus.BASEBALL_DEFAULT_SIZE;

    @Test
    void Answer_생성자의_인자가_기본길이를_충족하지않으면_예외() {
        List<Integer> init = List.of(1, 2);
        assertThatThrownBy(() -> new Answer(init)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void Answer_생성자의_인자가_중복된값을_가지면_예외() {
        List<Integer> init = List.of(1, 2, 2);
        assertThatThrownBy(() -> new Answer(init)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void Answer_생성자의_인자가_1부터_9사이의_값이_아닌값을_가지면_예외() {
        List<Integer> init = List.of(1, 2, 10);
        assertThatThrownBy(() -> new Answer(init)).isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void get_메소드는_해당_index의_값을_반환한다() {
        assertThat(answer.get(0)).isEqualTo(init.get(0));
    }

    @Test
    void size_메소드는_List의_길이를_반환한다() {
        assertThat(answer.size()).isEqualTo(init.size());
    }

    @Nested
    class contains_메소드는_인자로_들어온값이_ {
        @Test
        void 존재하면_True를_반환한다() {
            assertThat(answer.contains(1)).isTrue();
        }

        @Test
        void 존재하지_않으면_False를_반환한다() {
            assertThat(answer.contains(8)).isFalse();
        }

    }
}