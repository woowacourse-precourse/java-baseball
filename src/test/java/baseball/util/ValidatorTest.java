package baseball.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.domain.Ball;
import baseball.domain.BallCount;
import baseball.domain.Numbers;
import baseball.domain.Strike;
import baseball.rule.EndRule;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidatorTest {

    @Test
    @DisplayName("스트라이크 0 미만시 IllegalArgumentException 발생")
    void 스트라이크_0미만_예외() {
        assertThatThrownBy(
            () -> new BallCount(-1, 2)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("스트라이크 3 초과시 IllegalArgumentException 발생")
    void 스트라이크_3초과_예외() {
        assertThatThrownBy(
            () -> new BallCount(4, 2)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("볼 0 미만시 IllegalArgumentException 발생")
    void 볼_0미만_예외() {
        assertThatThrownBy(
            () -> new BallCount(2, -1)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("볼 3 초과시 IllegalArgumentException 발생")
    void 볼_3초과_예외() {
        assertThatThrownBy(
            () -> new BallCount(2, 4)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("리스트에 중복 숫자 발견 시 IllegalArgumentException 예외 발생")
    void 중복된_숫자_예외() {
        List<Integer> numbers = List.of(1, 2, 2);
        assertThatThrownBy(
            () -> {
                new Numbers(numbers);
            }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("리스트에 숫자 4개 이상 입력 시 IllegalArgumentException 예외 발생")
    void 숫자_4개이상_예외() {
        List<Integer> numbers = List.of(1, 2, 3, 4);
        assertThatThrownBy(
            () -> {
                new Numbers(numbers);
            }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("유저가 1과 2 이외의 값 입력시 IllegalArgumentException 예외 발생")
    void 유저입력값_1과2_이외값_입력시_예외발생() {
        Assertions.assertThatThrownBy(
            () -> EndRule.isProgramEnd("3")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("0~3 범위 이외 볼카운트 입력시 원시값 IllegalArgumentException 예외 발생")
    void 볼카운트_범위_외_예외발생() {
        Assertions.assertThatThrownBy(
            () -> new Ball(4)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("0~3 범위 이외 스트라이크카운트 입력시 원시값 IllegalArgumentException 예외 발생")
    void 스트라이크카운트_범위_외_예외발생() {
        Assertions.assertThatThrownBy(
            () -> new Strike(-1)
        ).isInstanceOf(IllegalArgumentException.class);
    }

}
