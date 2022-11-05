package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberTest {

    @Test
    void create() {
        Number actual = Number.of(1);

        assertThat(actual == Number.of(1)).isTrue();
    }

    @DisplayName("1부터 9까지 수가 아닌 경우 IllegalArgumentException 예외를 throw 한다.")
    @Test
    void validate_bound() {
        Assertions.assertAll(
                () -> assertThatThrownBy(() -> Number.of(0)).isInstanceOf(IllegalArgumentException.class),
                () -> assertThat(Number.of(1)).isInstanceOf(Number.class),
                () -> assertThat(Number.of(9)).isInstanceOf(Number.class),
                () -> assertThatThrownBy(() -> Number.of(10)).isInstanceOf(IllegalArgumentException.class)
        );
    }
}
