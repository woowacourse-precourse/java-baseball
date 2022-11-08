package baseball;

import static baseball.constant.Rules.END_INCLUSIVE;
import static baseball.constant.Rules.NUMBER_LENGTH;
import static baseball.constant.Rules.START_INCLUSIVE;
import static baseball.util.RandomUtil.generateComputerNumber;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.RepeatedTest;

public class NumberGeneratorTest {

    @RepeatedTest(10)
    void 컴퓨터숫자는_1부터_9로만_이루어져야함() {
        List<Integer> computer = generateNumber();
        boolean isValidRange = computer.stream()
                .allMatch(digit -> digit >= START_INCLUSIVE && digit <= END_INCLUSIVE);
        assertThat(isValidRange).isTrue();
    }

    @RepeatedTest(10)
    void 컴퓨터숫자는_서로_다른_수로만_이루어져야함() {
        List<Integer> computer = generateNumber();
        assertThat(computer.stream().distinct().count()).isEqualTo(computer.size());
    }

    @RepeatedTest(10)
    void 컴퓨터숫자는_세자리여야함() {
        List<Integer> computer = generateNumber();
        assertThat(computer.size()).isEqualTo(NUMBER_LENGTH);
    }

    private List<Integer> generateNumber() {
        return generateComputerNumber();
    }
}
