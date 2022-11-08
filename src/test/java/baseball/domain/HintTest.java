package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HintTest {

    @Test
    void create() {
        assertAll(
                () -> assertThat(Hint.STRIKE == Hint.STRIKE).isTrue(),
                () -> assertThat(Hint.BALL == Hint.BALL).isTrue()
        );
    }

    @DisplayName("파라미터로 넘긴 힌트가 몇 개 있는지 반환한다.")
    @Test
    void count() {
        Hints hints = new Hints(List.of(Hint.STRIKE, Hint.STRIKE, Hint.BALL));

        assertAll(
                () -> assertThat(hints.count(Hint.STRIKE)).isEqualTo(2),
                () -> assertThat(hints.count(Hint.BALL)).isEqualTo(1)
        );
    }

    @DisplayName("스트라이크 또는 볼이 없는 경우 true를 반환한다.")
    @Test
    void isNothing() {
        Hints hints = new Hints(List.of());

        assertThat(hints.isNothing()).isTrue();
    }
}
