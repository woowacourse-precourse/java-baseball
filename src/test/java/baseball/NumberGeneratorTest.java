package baseball;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

public class NumberGeneratorTest {

    NumberGenerator numberGenerator;

    @BeforeEach
    public void beforeEach() {
        numberGenerator = new RandomNumberGenerator();
    }

    @RepeatedTest(10)
    public void 컴퓨터숫자는_1부터_9로만_이루어져야함() {
        int numberLength = 3;
        List<Integer> computer = numberGenerator.generateComputerNumber(numberLength);
        boolean isValidRange = computer.stream().allMatch(digit -> digit >= 1 && digit <= 9);
        Assertions.assertThat(isValidRange).isTrue();
    }

    @RepeatedTest(10)
    public void 컴퓨터숫자는_서로_다른_수로만_이루어져야함() {
        int numberLength = 3;
        List<Integer> computer = numberGenerator.generateComputerNumber(numberLength);
        Assertions.assertThat(computer.stream().distinct().count()).isEqualTo(computer.size());
    }

    @RepeatedTest(10)
    public void 컴퓨터숫자는_세자리여야함() {
        int numberLength = 3;
        List<Integer> computer = numberGenerator.generateComputerNumber(numberLength);
        Assertions.assertThat(computer.size()).isEqualTo(numberLength);
    }
}
