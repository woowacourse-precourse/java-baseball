package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ValidationTest {
    @Test
    void isNumber() {
        assertThat(Validation.isNumber("onetwothree")).isSameAs(false);
        assertThat(Validation.isNumber("123")).isSameAs(true);
    }

    @Test
    void isThreePosition() {
        assertThat(Validation.isThreePosition(1234)).isSameAs(false);
        assertThat(Validation.isThreePosition(12)).isSameAs(false);
        assertThat(Validation.isThreePosition(123)).isSameAs(true);
    }

    @Test
    void isDifferent() {
        assertThat(Validation.isDifferent(122)).isSameAs(false);
        assertThat(Validation.isDifferent(191)).isSameAs(false);
        assertThat(Validation.isDifferent(145)).isSameAs(true);
    }

    @Test
    void isAnswer() {
        assertThat(Validation.isAnswer("1")).isSameAs(true);
        assertThat(Validation.isAnswer("2")).isSameAs(true);
        assertThat(Validation.isAnswer("3")).isSameAs(false);
    }

    @Test
    void isContainZero() {
        assertThat(Validation.isContainZero(104)).isSameAs(false);
        assertThat(Validation.isContainZero(154)).isSameAs(true);
    }
}