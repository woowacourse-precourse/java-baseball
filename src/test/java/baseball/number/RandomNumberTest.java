package baseball.number;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class RandomNumberTest {

    RandomNumber randomNumber;

    @BeforeEach
    void init() {
        randomNumber = new RandomNumber();
    }

    @Test
    void 랜덤숫자_길이_테스트() {
        List<String> randomNumbers = randomNumber.createRandomNumber();
        Assertions.assertThat(randomNumbers.size()).isSameAs(3);
    }
}