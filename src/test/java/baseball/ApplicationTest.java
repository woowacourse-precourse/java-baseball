package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }


    @Nested
    @DisplayName("사용자의 입력 테스트")
    class PlayerInputTest{

        @Test
        @DisplayName("입력값에 문자가 포함된 경우 예외처리")
        void PlayerInputTest1(){
            Player player = new Player();

            assertThatThrownBy(() -> player.input("a23"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("입력값은 숫자만 포함되어야 합니다.");

        }

        @Test
        @DisplayName("입력값에 0이 포함된 경우 예외처리")
        void PlayerInputTest2(){
            Player player = new Player();

            assertThatThrownBy(() -> player.input("012"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("입력값에 0이 포함될 수 없습니다.");

        }


        @Test
        @DisplayName("입력값이 세자리가 아닌 경우 예외처리")
        void PlayerInputTest3(){
            Player player = new Player();

            assertThatThrownBy(() -> player.input("0123"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("입력값은 세자리여야 합니다.");
        }


        @Test
        @DisplayName("입력값에 수의 중복이 존재하는 경우 예외처리")
        void PlayerInputTest4(){
            Player player = new Player();

            assertThatThrownBy(() -> player.input("113"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("입력값에 수의 중복이 존재합니다.");
        }
    }

}
