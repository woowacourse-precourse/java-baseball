package baseball.domain.referee;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class RefereeImplTest {
    @Nested
    class updateEachSetContextTest {
        @Test
        @DisplayName("결과가 3스트라이크일 경우 레프리는 게임 진행을 멈춘다.")
        void Case1() {
            //given
            Referee referee = new RefereeImpl();
            boolean beforeEachSetContext = referee.isEachSetContext();

            String resultMessage = "3스트라이크";

            //when
            referee.updateEachSetContext(resultMessage);

            //then
            boolean afterEachSetContext = referee.isEachSetContext();
            assertThat(beforeEachSetContext).isEqualTo(true);
            assertThat(afterEachSetContext).isEqualTo(false);

        }

        @Test
        @DisplayName("결과가 3스트라이크가 아닐 경우 레프리는 게임을 계속 진행한다.")
        void Case2() {
            //given
            Referee referee = new RefereeImpl();
            boolean beforeEachSetContext = referee.isEachSetContext();

            String resultMessage = "1볼 2스타라이크";

            //when
            referee.updateEachSetContext(resultMessage);

            //then
            boolean afterEachSetContext = referee.isEachSetContext();
            assertThat(beforeEachSetContext).isEqualTo(true);
            assertThat(afterEachSetContext).isEqualTo(true);

        }
    }
}
