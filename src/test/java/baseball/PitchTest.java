package baseball;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;


public class PitchTest {

    Pitch pitch = new Pitch();

    @Test
    void getUserInputToGuess_메서드_사용시_모든_인덱스를_배열에_저장해_반환() {
        String input = "따로따로";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String[] result = {"따","로"};

        assertThat(pitch.getUserInputToGuess()).contains(result);

    }
    @Test
    void setUserAnswer_메서드_사용시_규격에_맞지_않으면_예외_발생() {
        String input = "0334ㄹ";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> pitch.setUserAnswer())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void setUserAnswer_메서드_사용시_규격에_맞으면_Integer_변환해_userAnswer_저장() {
        String input = "123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        pitch.setUserAnswer();

        assertThat(Pitch.userAnswer).contains(1, 2, 3);
    }

    @Test
    void checkCorrect_메서드_사용시_정답이면_true_반환() {
        Hint.hint = "3스트라이크";
        boolean isCorrect = pitch.checkCorrect(Hint.hint);

        assertThat(isCorrect).isTrue();
    }

}
