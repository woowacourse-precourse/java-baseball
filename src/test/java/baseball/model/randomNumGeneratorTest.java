package baseball.model;

import static baseball.model.RandomNumGenerator.generate;
import static baseball.controller.InputValidator.INPUT_LENGTH;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class randomNumGeneratorTest {

    @Test
    public void numSizeTest() {
        List<Integer> randomNum = generate();
        assertThat(randomNum.size())
                .isEqualTo(INPUT_LENGTH);
    }

    @Test
    public void duplicateTest() {
        List<Integer> randomNum = generate();
        Set<Integer> randomNumNotDuplicated = new HashSet<>(randomNum);

        assertThat(randomNumNotDuplicated.size())
                .isEqualTo(INPUT_LENGTH);
    }

    @Test
    @RepeatedTest(100)
    public void validRangeTest() {
        List<Integer> randomNum = generate();

        assertThat(randomNum).filteredOn(i -> i < 1 && i > 9)
                .hasSize(0);
    }
}
