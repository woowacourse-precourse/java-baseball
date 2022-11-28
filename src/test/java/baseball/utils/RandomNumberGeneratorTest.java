package baseball.utils;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    private NumberGenerator numbersGenerator;
    private List<Integer> validNumbers = Arrays.asList(1,2,3,4,5,6,7,8,9);

    @BeforeEach
    void setUp() {
        RandomNumberGenerator numbersGenerator = new RandomNumberGenerator();
        this.numbersGenerator = numbersGenerator;
    }


    @Test
    void generate_반환_List_크기_3_확인() {
        assertThat(numbersGenerator.generate().size()).isEqualTo(Constants.NUMBERS_SIZE);
    }

    @Test
    void generate_반환값_범위_1에서_9사이_확인() {
        List<Integer> randomNumbers = numbersGenerator.generate();
        for (int number : randomNumbers) {
            assertThat(validNumbers).contains(number);
        }
    }

    @Test
    void generate_반환값_모두_다른_숫자_확인() {
        Set<Integer> randomNumbers = new HashSet<>(numbersGenerator.generate());
        assertThat(randomNumbers.size()).isEqualTo(Constants.NUMBERS_SIZE);
    }
}