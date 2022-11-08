package baseball.player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {

    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player();
    }

    @Nested
    class SuccessCase {
        @Test
        void 플레이어가_가진_숫자가_3개인지_확인() {
            String input = "123";
            String verification = player.inputVerification(input);
            assertThat(input).isEqualTo(verification);
        }

        @Test
        void 플레이어가_0을_입력하지_않았을_경우() {
            String input = "876";
            String verification = player.inputVerification(input);
            assertThat(input).isEqualTo(verification);
        }

        @Test
        void 플레이어가_중복된_값을_입력하지_않았을_경우() {
            String input = "567";
            String verification = player.inputVerification(input);
            assertThat(input).isEqualTo(verification);
        }
    }

    @Nested
    class Edge_Case {
        @Test
        void 플레이어가_가진_숫자가_3개가_아닌경우_예외처리가_되는지_확인() {
            String input = "1234";
            assertThatThrownBy(() -> player.inputVerification(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("플레이어가 숫자 3개를 입력하지 않았습니다.");
        }

        @Test
        void 플레이어가_0을_입력하였을_경우_예외처리가_되는지_확인() {
            String input = "406";
            assertThatThrownBy(() -> player.inputVerification(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("플레이어가 세자리중 '0'을 입력하였습니다.");
        }

        @Test
        void 플레이어가_중복된_값을_입력하였을_경우_예외처리가_되는지_확인() {
            String input = "727";
            assertThatThrownBy(() -> player.inputVerification(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("플레이어가 중복된 값을 입력하였습니다.");
        }

        @Test
        void 플레이어가_1부터_9사이의_값이_아닌_다른값을_입력하였을_경우_예외처리가_되는지_확인() {
            String input = "abc";
            assertThatThrownBy(() -> player.inputVerification(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("플레이어가 1부터 9사이의 값을 입력하지 않았습니다.");
        }
    }
}