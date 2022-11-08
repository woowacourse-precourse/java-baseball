package baseball.RandomGeneration;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.Application.getRandomThreeNumber;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RandomGenerationTest {
    @Test
    void generateThreeNumber() {
        List<Integer> numberList = getRandomThreeNumber();
        assertThat(numberList.size()).isEqualTo(3);
    }

    @Test
    void generateDifferentRandomNumber() {
        List<Integer> numberList = getRandomThreeNumber();
        Set<Integer> numberSet = new HashSet<>(numberList);
        assertThat(numberSet.size()).isEqualTo(3);
    }
}
