package baseball;

import baseball.RandomBallNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class RandomBallNumberTest {

    RandomBallNumber randomBallNumber;

    @BeforeEach
    void init() {
        randomBallNumber = new RandomBallNumber();
    }

    @Test
    void 랜덤숫자_길이_테스트() {
        List<String> randomNumbers = randomBallNumber.createRandomNumber();
        Assertions.assertThat(randomNumbers.size()).isSameAs(3);
    }
}