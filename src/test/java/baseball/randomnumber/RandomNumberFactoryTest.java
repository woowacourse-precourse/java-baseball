package baseball.randomnumber;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RandomNumberFactoryTest {

    @Nested
    class 세개의_숫자가_생성된다 {
        @RepeatedTest(10)
        void 세개의_숫자가_생성된다() {
            RandomNumber randomNumber = RandomNumberFactory.newRandomNumber();
            List<Integer> answer = randomNumber.getAnswer();
            assertThat(answer.size()).isEqualTo(3);
        }
    }

    @Nested
    class 세개의_숫자는_서로_다르다 {
        @RepeatedTest(10)
        void 세개의_숫자는_서로_다르다() {
            RandomNumber randomNumber = RandomNumberFactory.newRandomNumber();
            List<Integer> answer = randomNumber.getAnswer();

            Integer firstNumber = answer.get(0);
            Integer secondNumber = answer.get(1);
            Integer thirdNumber = answer.get(2);

            assertThat(firstNumber).isNotEqualTo(secondNumber);
            assertThat(secondNumber).isNotEqualTo(thirdNumber);
            assertThat(firstNumber).isNotEqualTo(thirdNumber);
        }
    }

    @Test
    void 만들어진_RandomNumber를_바꿀수_없다() {
        RandomNumber randomNumber = RandomNumberFactory.newRandomNumber();
        List<Integer> answer = randomNumber.getAnswer();

        assertThatThrownBy(() -> answer.add(100))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}