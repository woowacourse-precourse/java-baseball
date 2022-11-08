package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class NumberMakerTest {

    @Test
    void makeInitRandomNumber() {
        NumberMaker numberMaker = new NumberMaker();
        String testString = numberMaker.makeInitRandomNumber();
        assertThat(testString.length()).isEqualTo(3);
        assertThat(Integer.parseInt(testString))
                .isGreaterThan(122)
                .isLessThan(988);
    }
}