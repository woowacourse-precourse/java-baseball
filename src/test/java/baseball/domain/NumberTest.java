package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.Number;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class NumberTest {

    private Number number;

    @BeforeEach
    void setNumber() {
        number = new Number();
    }

    @Test
    void 스트라이크_테스트() {
        number.hitStrike();

        assertThat(number.getStrike()).isEqualTo(1);
    }

    @Test
    void 볼_테스트() {
        number.hitBall();

        assertThat(number.getBall()).isEqualTo(1);
    }
}
