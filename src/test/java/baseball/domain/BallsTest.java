package baseball.domain;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

@Tag("Unit")
class BallsTest {

    @Test
    void 중복_예외_테스트() {

        assertThatThrownBy(() -> new Balls(List.of(1, 1, 1)))
                .isInstanceOf(IllegalArgumentException.class)
                .withFailMessage("Numbers is duplicate");
    }

    @Test
    void 길이_예외_테스트() {

        assertAll(
                () -> assertThatThrownBy(() -> new Balls(List.of(1, 2)))
                        .isInstanceOf(IllegalArgumentException.class)
                        .withFailMessage("Numbers is duplicate"),
                () -> assertThatThrownBy(() -> new Balls(List.of(1, 2, 3, 5)))
                        .isInstanceOf(IllegalArgumentException.class)
                        .withFailMessage("Numbers is duplicate")
        );

    }
}