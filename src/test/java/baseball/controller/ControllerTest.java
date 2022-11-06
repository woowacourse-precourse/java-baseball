package baseball.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ControllerTest {

    Controller controller = new Controller();

    @DisplayName("chooseRestartOrEnd 메서드는")
    @Nested
    class RestartOrNotTest {

        @DisplayName("1을 입력하면 재시작한다")
        @Test
        void 재시작() {
            final String args = "1";
            System.setIn(new ByteArrayInputStream(args.getBytes()));
            assertThat(controller.chooseRestartOrEnd()).isEqualTo(true);
        }

        @DisplayName("2를 입력하면 종료한다")
        @Test
        void 종료() {
            final String args = "2";
            System.setIn(new ByteArrayInputStream(args.getBytes()));
            assertThat(controller.chooseRestartOrEnd()).isEqualTo(false);
        }

        @DisplayName("그 외를 입력하면 예외가 발생한다")
        @Test
        void 예외_발생() {
            final String args = "3";
            System.setIn(new ByteArrayInputStream(args.getBytes()));
            assertThatThrownBy(() -> controller.chooseRestartOrEnd())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("잘못 입력");
        }
    }
}
