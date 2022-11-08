package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GamerTest {
    Gamer gamer = new Gamer();

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    @Nested
    @DisplayName("입력값이_제약조건에서_벗어나면_예외를_발생시킨다")
    class GamerInputTest {
        @Test
        void 입력값의_길이가_3보다_크면_예외를_발생시킨다() {
            // Given
            String input = "1234";

            // When
            command(input);

            // Then
            assertThatThrownBy(() -> gamer.inputThreeDiffDigit())
                    .isInstanceOf(IllegalArgumentException.class);
        }
        @Test
        void 입력값이_숫자타입으로_형변환_할_수_없는_문자열이면_예외를_발생시킨다() {
            // Given
            String input = "1@3$";

            // When
            command(input);

            // Then
            assertThatThrownBy(() -> gamer.inputThreeDiffDigit())
                    .isInstanceOf(IllegalArgumentException.class);
        }
        @Test
        void 입력값의_각_자리수_중_중복값이_있다면_예외를_발생시킨다() {
            // Given
            String input = "122";

            // When
            command(input);

            // Then
            assertThatThrownBy(() -> gamer.inputThreeDiffDigit())
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    void 입력값이_replay_혹은_quit_의_숫자값이_아니면_예외를_발생시킨다() {
        // Given
        String input = "4";

        // When
        command(input);

        // Then
        assertThatThrownBy(() -> gamer.inputPlayAgainOrNot())
                .isInstanceOf(IllegalArgumentException.class);
    }

}
