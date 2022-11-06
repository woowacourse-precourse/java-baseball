package baseball.mvc.view;

import baseball.util.GameGuideViewTestUtils;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class GameGuideViewTest {

    private final ByteArrayOutputStream testOut = new ByteArrayOutputStream();
    private PrintStream standardOut;

    @BeforeEach
    void beforeEach() {
        testOut.reset();
        standardOut = System.out;
        System.setOut(new PrintStream(testOut));
    }

    @AfterEach
    void afterEach() {
        System.setOut(standardOut);
        System.out.println(testOut.toString().trim());
    }

    @Nested
    @DisplayName("printGuideLog 메소드는")
    class GameGuideViewMethodTest {

        @Test
        @DisplayName("만약 GameGuideView.START라면 최초 게임 시작 안내 문구를 출력한다.")
        void start_log_test() {
            GameGuideView.START.printGuideLog();

            Assertions.assertThat(testOut.toString())
                    .isEqualTo(GameGuideViewTestUtils.getMessage(GameGuideView.START, testOut));
        }

        @Test
        @DisplayName("만약 GameGuideView.END라면 정답을 맞춰 게임을 종료한다는 안내 문구를 출력한다.")
        void end_log_test() {
            GameGuideView.END.printGuideLog();

            Assertions.assertThat(testOut.toString())
                    .isEqualTo(GameGuideViewTestUtils.getMessage(GameGuideView.END, testOut));
        }
    }
}