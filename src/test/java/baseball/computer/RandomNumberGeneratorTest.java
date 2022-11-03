package baseball.computer;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {
    @Test
    void 난수_각자릿수_확인() {
        HashSet<List<Integer>> gameNumberSet = new HashSet<>();
        for (int testNumbers = 0; testNumbers < 100; testNumbers++) {
            assertThat(isDigitAOtherNumber()).isEqualTo(true);
        }
    }

    private static boolean isDigitAOtherNumber() {
        List<Integer> gameNumbers = RandomNumberGenerator.generateRandomNumbers();
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
