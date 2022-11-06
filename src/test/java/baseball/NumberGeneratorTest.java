package baseball;

import static constant.Rules.END_INCLUSIVE;
import static constant.Rules.NUMBER_LENGTH;
import static constant.Rules.START_INCLUSIVE;

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
        List<Integer> computer = generateNumber();
        boolean isValidRange = computer.stream()
                .allMatch(digit -> digit >= START_INCLUSIVE && digit <= END_INCLUSIVE);
        Assertions.assertThat(isValidRange).isTrue();
    }

    @RepeatedTest(10)
    public void 컴퓨터숫자는_서로_다른_수로만_이루어져야함() {
        List<Integer> computer = generateNumber();
        Assertions.assertThat(computer.stream().distinct().count()).isEqualTo(computer.size());
    }

    @RepeatedTest(10)
    public void 컴퓨터숫자는_세자리여야함() {
        List<Integer> computer = generateNumber();
        Assertions.assertThat(computer.size()).isEqualTo(NUMBER_LENGTH);
    }

    private List<Integer> generateNumber() {
        return numberGenerator.generateComputerNumber();
    }
}
