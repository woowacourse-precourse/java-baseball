package baseball.validator;

import baseball.player.Computer;
import baseball.player.Playable;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class RefereeTest {

    @Test
    void setAnswer_정답_설정() {
        // given
        Validator referee = new Referee();
        List<Integer> answer = List.of(1, 2, 3);

        // when
        referee.setAnswer(answer);

        // then
        assertThat(referee.getAnswer()).isEqualTo(answer);
    }

    @Test
    void setAnswer_정답_유효성_길이_확인() {
        // given
        Validator referee = new Referee();
        List<Integer> answer1 = List.of(1, 2, 3, 4);
        List<Integer> answer2 = List.of(1, 2);
        List<Integer> answer3 = List.of();

        // when
        // then
        assertThatThrownBy(() -> referee.setAnswer(answer1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> referee.setAnswer(answer2))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> referee.setAnswer(answer3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void setAnswer_정답_유효성_범위_확인() {
        // given
        Validator referee = new Referee();
        List<Integer> answer1 = List.of(1, 2, 0);
        List<Integer> answer2 = List.of(1, 2, 10);

        // when
        // then
        assertThatThrownBy(() -> referee.setAnswer(answer1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> referee.setAnswer(answer2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void setAnswer_정답_유효성_중복_확인() {
        // given
        Validator referee = new Referee();
        List<Integer> answer1 = List.of(1, 1, 3);
        List<Integer> answer2 = List.of(10, 10);
        List<Integer> answer3 = List.of(1, 2, 3, 3);

        // when
        // then
        assertThatThrownBy(() -> referee.setAnswer(answer1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> referee.setAnswer(answer2))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> referee.setAnswer(answer3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkAnswer_정답_확인() {
        // given
        Validator referee = new Referee();
        List<Integer> answer = List.of(1, 2, 3);
        referee.setAnswer(answer);

        List<Integer> inputAnswer1 = List.of(1, 2, 3);
        List<Integer> inputAnswer2 = List.of(1, 3, 2);

        // when
        boolean result1 = referee.checkAnswer(inputAnswer1);
        boolean result2 = referee.checkAnswer(inputAnswer2);

        // then
        assertThat(result1).isEqualTo(true);
        assertThat(result2).isEqualTo(false);
    }

}