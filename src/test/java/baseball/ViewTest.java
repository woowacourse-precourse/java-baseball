package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static baseball.view.PrintMessage.*;

public class ViewTest {
    @Nested
    class 지시문 {
        @Test
        void 게임시작() {
            Assertions.assertThat(GAME_START.getMessage()).isEqualTo("숫자 야구 게임을 시작합니다.");
        }

        @Test
        void 데이터입력() {
            Assertions.assertThat(INPUT_DATA.getMessage()).isEqualTo("숫자를 입력해주세요 : ");
        }

        @Test
        void 재시작_중지() {
            Assertions.assertThat(RUN_CODE.getMessage())
                    .isEqualTo("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }
    }

    @Nested
    class 결과 {
        @Test
        void 볼() {
            Assertions.assertThat(1 + BALL.getMessage()).isEqualTo("1볼");
            Assertions.assertThat(2 + BALL.getMessage()).isEqualTo("2볼");
            Assertions.assertThat(3 + BALL.getMessage()).isEqualTo("3볼");
        }

        @Test
        void 스트라이크() {
            Assertions.assertThat(1 + STRIKE.getMessage()).isEqualTo("1스트라이크");
            Assertions.assertThat(2 + STRIKE.getMessage()).isEqualTo("2스트라이크");
            Assertions.assertThat(3 + STRIKE.getMessage()).isEqualTo("3스트라이크");
            Assertions.assertThat(SUCCESS.getMessage()).isEqualTo("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }

        @Test
        void 낫싱() {
            Assertions.assertThat(NOTHING.getMessage()).isEqualTo("낫싱");
        }

    }

    @Nested
    class 볼_스트라이크 {
        @Test
        void 볼1_스트라이크1() {
            Assertions.assertThat(1 + BALL.getMessage() + " " + 1 + STRIKE.getMessage())
                    .isEqualTo("1볼 1스트라이크");
        }

        @Test
        void 볼2_스트라이크1() {
            Assertions.assertThat(2 + BALL.getMessage() + " " + 1 + STRIKE.getMessage())
                    .isEqualTo("2볼 1스트라이크");
        }
    }
}
