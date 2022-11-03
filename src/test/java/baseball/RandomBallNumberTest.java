package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomBallNumberTest {

    RandomBallNumber randomBallNumber;

    @BeforeEach
    void init() {
        randomBallNumber = new RandomBallNumber();
    }

    @Test
    void 랜덤숫자_길이_테스트() {
        String randomNum = randomBallNumber.createRandomNum();
        assertThat(randomNum.length()).isSameAs(3);
    }
}