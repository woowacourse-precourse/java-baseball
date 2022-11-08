package baseball;

import baseball.core.Count;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CountTest {
    @Test
    void constructor_test() {
        Count count = new Count();
        assertThat(count.getBall()).isEqualTo(0);
        assertThat(count.getStrike()).isEqualTo(0);
    }
    @Test
    void setter_getter_test() {
        Count count = new Count();
        count.setBall(1);
        count.setStrike(2);
        assertThat(count.getBall()).isEqualTo(1);
        assertThat(count.getStrike()).isEqualTo(2);
    }
    @Test
    void add_test() {
        Count count = new Count();
        count.addBall();
        count.addStrike();
        assertThat(count.getBall()).isEqualTo(1);
        assertThat(count.getStrike()).isEqualTo(1);
    }
    @Test
    void add_multiple_times_test() {
        Count count = new Count();
        for (int i = 0; i < 10; i++) {
            count.addBall();
            count.addStrike();
        }
        assertThat(count.getBall()).isEqualTo(10);
        assertThat(count.getStrike()).isEqualTo(10);
    }
    @Test
    void toString_only_balls_test() {
        Count count = new Count();
        count.setBall(2);
        assertThat(count.toString()).isEqualTo("2볼");
    }
    @Test
    void toString_only_strikes_test() {
        Count count = new Count();
        count.setStrike(2);
        assertThat(count.toString()).isEqualTo("2스트라이크");
    }
    @Test
    void toString_nothing_test() {
        Count count = new Count();
        assertThat(count.toString()).isEqualTo("낫싱");
    }
    @Test
    void toString_both_balls_strikes_test() {
        Count count = new Count();
        count.setBall(2);
        count.setStrike(1);
        assertThat(count.toString()).isEqualTo("2볼 1스트라이크");
    }
}
