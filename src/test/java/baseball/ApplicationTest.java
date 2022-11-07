package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
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

    @Test
    @DisplayName("랜덤 숫자 테스트")
    void randomNumberTest() {
        List<Integer> test = CreateRandomNumber.create();
        assertThat(3).isEqualTo(test.size());
        assertThat(test).doesNotHaveDuplicates();
    }

    @Test
    @DisplayName("정답 비교 테스트")
    void compareNumberTest() {
        Ball ball = CompareNumber.compare(List.of(1, 2, 3), List.of(3, 1, 2));
        assertThat(0).isEqualTo(ball.getStrike());
        assertThat(3).isEqualTo(ball.getBall());
        ball = CompareNumber.compare(List.of(1, 2, 3), List.of(1, 3, 2));
        assertThat(1).isEqualTo(ball.getStrike());
        assertThat(2).isEqualTo(ball.getBall());
        ball = CompareNumber.compare(List.of(1, 2, 3), List.of(1, 2, 3));
        assertThat(3).isEqualTo(ball.getStrike());
        assertThat(0).isEqualTo(ball.getBall());
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
