package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class NumberBaseballGameTest {

    @DisplayName("run 메서드는 랜덤으로 숫자를 생성해 게임을 진행하는데,")
    @Nested
    public class describe_run extends NsTest {

        @Override
        protected void runMain() {
            numberBaseballGameMain();
        }

        @Test
        @DisplayName("사용자가 알맞은 수를 입력한 경우 게임을 종료한다.")
        void end_game_when_user_input_right_number() {
            assertRandomNumberInRangeTest(() -> {
                run("246", "135");
                assertThat(output()).contains("낫싱", "3스트라이크");
            }, 1, 3, 5);
        }

        @Test
        @DisplayName("사용자가 잘못된 값을 입력한 경우 예외를 반환한다.")
        void generate_random_number_and_play_theGame() {
            org.assertj.core.api.Assertions.assertThatThrownBy(
                () -> assertRandomNumberInRangeTest(() -> {
                    run("24", "135");
                    assertThat(output()).contains("낫싱", "3스트라이크");
                }, 1, 3, 5)).isInstanceOf(IllegalArgumentException.class);
        }
    }

    void numberBaseballGameMain() {
        NumberBaseballGame baseballGame = new NumberBaseballGame();
        baseballGame.run();
    }
}
