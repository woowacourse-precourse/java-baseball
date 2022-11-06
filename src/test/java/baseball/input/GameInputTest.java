package baseball.input;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameInputTest {
    @Test
    @DisplayName("서로 다른 3자릿수가 제대로 저장된다.")
    public void uniqueDigit() {
        GameInput input = new GameInput(123);
        assertThat(input.number.first).isEqualTo(1);
        assertThat(input.number.second).isEqualTo(2);
        assertThat(input.number.third).isEqualTo(3);
    }

    @Test
    @DisplayName("3자리수가 아닐 때 예외를 던진다")
    public void notThreeDigitThrowsException() {
        assertThatThrownBy(()-> new GameInput(1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3자리 수를 입력해주세요.");
    }

    @Test
    @DisplayName("3자리수 중 같은 숫자가 있을 때 예외를 던진다")
    public void duplicateDigitThrowsException() {
        assertThatThrownBy(()-> new GameInput(111))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("서로 다른 3자리 수를 입력해주세요.");

        assertThatThrownBy(()-> new GameInput(772))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("서로 다른 3자리 수를 입력해주세요.");

        assertThatThrownBy(()-> new GameInput(121))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("서로 다른 3자리 수를 입력해주세요.");

        assertThatThrownBy(()-> new GameInput(633))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("서로 다른 3자리 수를 입력해주세요.");
    }
}