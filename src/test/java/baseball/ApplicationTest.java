package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static baseball.Application.generateAnswer;
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
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("111"))
                .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("012"))
                .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("str"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Nested
    @DisplayName("정답 생성 테스트")
    class GenerateAnswerTest {
        List<Integer> answer = new ArrayList<>();

        @BeforeEach
        void beforeEach() {
            answer = generateAnswer();
        }

        @Test
        @DisplayName("정답의 길이가 3인지 확인")
        void checkAnswerSize() {
            assertThat(answer.size()).isEqualTo(3);
        }

        @Test
        @DisplayName("각 자리의 수가 모두 다른지 확인")
        void checkRandomNumber () {
            assertThat(answer.stream()
                .distinct()
                .count()
            ).isEqualTo(3);
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
