package baseball.randomnumber;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {

    @Nested
    class 세개의_숫자가_생성된다 {
        @RepeatedTest(10)
        void 세개의_숫자가_생성된다() {
            List<Integer> randomNumber = RandomNumberGenerator.getRandomNumber();
            assertThat(randomNumber.size()).isEqualTo(3);
        }
    }

    @Nested
    class 세개의_숫자는_서로_다르다 {
        @RepeatedTest(10)
        void 세개의_숫자는_서로_다르다() {
            List<Integer> randomNumber = RandomNumberGenerator.getRandomNumber();
            Integer firstNumber = randomNumber.get(0);
            Integer secondNumber = randomNumber.get(1);
            Integer thirdNumber = randomNumber.get(2);

            assertThat(firstNumber).isNotEqualTo(secondNumber);
            assertThat(secondNumber).isNotEqualTo(thirdNumber);
            assertThat(firstNumber).isNotEqualTo(thirdNumber);
        }
    }



}