package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NumbersTest {

    @Test
    void validation_숫자_개수_확인() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> Numbers.of(1, 2, 3, 4));
        assertThat(exception != null).isTrue();
    }

    @Test
    void validation_숫자_범위_확인() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> Numbers.of(1, 0, 9));
        assertThat(exception != null).isTrue();
    }

    @Test
    void validation_숫자_중복_확인() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> Numbers.of(1, 2, 2));
        assertThat(exception != null).isTrue();
    }

    @Test
    void get_확인() {
        Numbers numbers = Numbers.of(3, 2, 1);
        assertThat(numbers.get(0)).isEqualTo(3);
        assertThat(numbers.get(1)).isEqualTo(2);
        assertThat(numbers.get(2)).isEqualTo(1);
    }

    @Test
    void indexOf_확인() {
        Numbers numbers = Numbers.of(3, 2, 1);
        assertThat(numbers.indexOf(1)).isEqualTo(2);
        assertThat(numbers.indexOf(2)).isEqualTo(1);
        assertThat(numbers.indexOf(3)).isEqualTo(0);
        assertThat(numbers.indexOf(8)).isEqualTo(-1);
    }
}
