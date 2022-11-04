package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    void 정답생성기_테스트() {
        // Given
        Integer[] answer = Application.generateAnswer();

        // When
        Set<Integer> answerSet = new HashSet<>(Arrays.asList(answer));

        // Then
        // 길이가 3
        assertThat(answer.length).isEqualTo(3);
        // 겹치는 숫자가 없음
        assertThat(answerSet.size()).isEqualTo(3);
        // 모든 숫자는 1~9 사이의 숫자임.
        for (int number : answer) {
            assertThat(number).isGreaterThan(0);
            assertThat(number).isLessThan(10);
        }
    }

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
}
