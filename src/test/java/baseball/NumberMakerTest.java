package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class NumberMakerTest {

    @Test
    void makeRandomNumber() {
        NumberMaker numberMaker = new NumberMaker();
        String testString = numberMaker.makeRandomNumber();
        assertThat(testString.length()).isEqualTo(3);
        assertThat(Integer.parseInt(testString))
                .isGreaterThan(122)
                .isLessThan(988);
    }

    @Test
    void makePlayerNumber() {
    }

}