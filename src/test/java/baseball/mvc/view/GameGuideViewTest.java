package baseball.mvc.view;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.helper.util.GameGuideViewTestUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class GameGuideViewTest extends OutputSettings {

    @Nested
    @DisplayName("printGuideLog 메소드는")
    class GameGuideViewMethodTest {

        @Test
        @DisplayName("만약 GameGuideView.START라면 최초 게임 시작 안내 문구를 출력한다.")
        void start_log_test() {
            GameGuideView.START.printGuideLog();

            assertThat(testOut.toString())
                    .contains(GameGuideViewTestUtils.getMessage(GameGuideView.START, testOut));
        }

        @Test
        @DisplayName("만약 GameGuideView.END라면 정답을 맞춰 게임을 종료한다는 안내 문구를 출력한다.")
        void end_log_test() {
            GameGuideView.END.printGuideLog();

            assertThat(testOut.toString())
                    .contains(GameGuideViewTestUtils.getMessage(GameGuideView.END, testOut));
        }
    }
}