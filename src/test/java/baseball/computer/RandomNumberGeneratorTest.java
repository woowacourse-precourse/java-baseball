package baseball.computer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.computer.generator.RandomNumberGenerator;
import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {
    @BeforeEach
    void init() {
        RandomNumberGenerator.initGenerator();
    }

    @Test
    void 난수_각자릿수_확인() {
        for (int testNumbers = 0; testNumbers < RandomNumberGenerator.MAX_NUMBER_OF_CASE; testNumbers++) {
            assertThat(isDigitAOtherNumber()).isEqualTo(true);
        }
    }

    @Test
    void 난수_0_확인() {
        for (int testNumbers = 0; testNumbers < RandomNumberGenerator.MAX_NUMBER_OF_CASE; testNumbers++) {
            List<Integer> gameNumbers = RandomNumberGenerator.generateRandomNumber();
            assertThat(gameNumbers.contains(0)).isEqualTo(false);
        }
    }

    @Test
    void 자릿수의_길이_확인() {
        for (int testNumbers = 0; testNumbers < RandomNumberGenerator.MAX_NUMBER_OF_CASE; testNumbers++) {
            List<Integer> gameNumbers = RandomNumberGenerator.generateRandomNumber();
            assertThat(gameNumbers.size()).isEqualTo(3);
        }
    }

    @Test
    void 중복_없는_모든_케이스_확인() {
        // given
        int numberCase = 0;
        List<Integer> numbers;
        HashSet<List<Integer>> numbersHash = new HashSet<>();

        // when then
        for (; numberCase < RandomNumberGenerator.MAX_NUMBER_OF_CASE; numberCase++) {
            numbers = RandomNumberGenerator.getRandomNumber();
            assertThat(numbersHash.contains(numbers)).isEqualTo(false);
            numbersHash.add(numbers);
        }
        checkOverCase();
    }

    private static void checkOverCase() {
        // when, then
        assertThatThrownBy(RandomNumberGenerator::getRandomNumber)
            .isInstanceOf(IllegalArgumentException.class);
    }

    private static boolean isDigitAOtherNumber() {
        List<Integer> gameNumbers = RandomNumberGenerator.generateRandomNumber();
        HashSet<Integer> numberSet = new HashSet<>();

        for (Integer number : gameNumbers) {
            if (numberSet.contains(number)) {
                return false;
            }
            numberSet.add(number);
        }
        return true;
    }
}
