package baseball;

import static baseball.ConstantAndMessage.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class NonDuplicateRandomNumberTest {

    @Test
    void 숫자_비율_검사() {
        final int NUMBER_NUMBERS = END_NUMBER - START_NUMBER + 1;
        int trails = 10000;
        double[] count = new double[NUMBER_NUMBERS];
        for (int i = 0; i < trails; i++) {
            List<Integer> randomNumbers = NonDuplicateRandomNumber.makingNumbers();
            for (int number : randomNumbers) {
                count[number - START_NUMBER]++;
            }
        }
        for (int i = 0; i < NUMBER_NUMBERS; i++) {
            assertThat(count[i] / (trails * NUMBER_LENGTH)).
                    isBetween((1.0 / NUMBER_NUMBERS - 0.005), (1.0 / NUMBER_NUMBERS + 0.005));
        }
    }
    @RepeatedTest(200)
    void 중복_확인() {
        List<Integer> randomNumbers = NonDuplicateRandomNumber.makingNumbers();
        boolean noDuplication = true;
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            noDuplication &= i == randomNumbers.lastIndexOf(randomNumbers.get(i));
        }
        assertThat(noDuplication).isEqualTo(true);
    }
}
