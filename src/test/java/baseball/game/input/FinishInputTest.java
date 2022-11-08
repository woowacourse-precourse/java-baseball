package baseball.game.input;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class FinishInputTest {
    @Nested
    @DisplayName("numberOf로 FinishInput 잘 생성하기")
    class NumberOfTest {
        @Test
        @DisplayName("1이 입력되면 재시작이 반환된다.")
        public void oneOfFinishInput() {
            FinishInput finishInput = FinishInput.numberOf(1);

            assertThat(finishInput).isEqualTo(FinishInput.RESTART_GAME);
        }

        @Test
        @DisplayName("2가 입력되면 게임종료가 반환된다.")
        public void twoOfFinishInput() {
            FinishInput finishInput = FinishInput.numberOf(2);

            assertThat(finishInput).isEqualTo(FinishInput.QUIT_GAME);
        }

        @Test
        @DisplayName("1또는 2가 아닐 경우 예외를 던진다.")
        public void invalidInput() {
            assertThatThrownBy(() -> FinishInput.numberOf(3))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("1또는 2를 입력해주세요.");
        }
    }

}