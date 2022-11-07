package baseball;

import baseball.domain.Player;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {
    public PlayerTest() {
        문자열을_리스트로_저장 문자열을_리스트로_저장 = new 문자열을_리스트로_저장();
        문자열을_리스트로_저장.case1();
        문자열을_리스트로_저장.case2();
        문자열을_리스트로_저장.case3();
        플레이어의_입력받은_수의_개수_예외_처리 개수 = new 플레이어의_입력받은_수의_개수_예외_처리();
        개수.case1();
        개수.case2();
        개수.case3();
        플레이어의_입력받은_수의_중복_예외_처리 중복 = new 플레이어의_입력받은_수의_중복_예외_처리();
        중복.case1();
        중복.case2();
        중복.case3();
    }

    @Nested
    class 문자열을_리스트로_저장 {
        @Test
        void case1() {
            Player player = new Player("123");
            Assertions.assertThat(player.getPlayerNumbers()).containsOnly(1, 2, 3);
        }

        @Test
        void case2() {
            Player player = new Player("236");
            Assertions.assertThat(player.getPlayerNumbers()).containsOnly(2, 3, 6);
        }

        @Test
        void case3() {
            Player player = new Player("635");
            Assertions.assertThat(player.getPlayerNumbers()).containsOnly(6, 3, 5);
        }
    }

    @Nested
    class 플레이어의_입력받은_수의_개수_예외_처리 {
        @Test
        void case1() {
            var ref = new Object() {
                Player player;
            };
            assertThatThrownBy(() -> ref.player = new Player("12"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("입력한 숫자의 개수가 올바르지 않습니다. 프로그램을 종료합니다.");
        }

        @Test
        void case2() {
            var ref = new Object() {
                Player player;
            };
            assertThatCode(() -> ref.player = new Player("123"))
                    .doesNotThrowAnyException();
        }

        @Test
        void case3() {
            var ref = new Object() {
                Player player;
            };
            assertThatThrownBy(() -> ref.player = new Player("1234"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("입력한 숫자의 개수가 올바르지 않습니다. 프로그램을 종료합니다.");
        }
    }

    @Nested
    class 플레이어의_입력받은_수의_중복_예외_처리 {
        @Test
        void case1() {
            var ref = new Object() {
                Player player;
            };
            assertThatThrownBy(() -> ref.player = new Player("112"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("입력한 숫자 중에 중복된 숫자가 있습니다. 프로그램을 종료합니다.");
        }

        @Test
        void case2() {
            var ref = new Object() {
                Player player;
            };
            assertThatCode(() -> ref.player = new Player("123"))
                    .doesNotThrowAnyException();
        }

        @Test
        void case3() {
            var ref = new Object() {
                Player player;
            };
            assertThatThrownBy(() -> ref.player = new Player("333"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("입력한 숫자 중에 중복된 숫자가 있습니다. 프로그램을 종료합니다.");
        }
    }
}
