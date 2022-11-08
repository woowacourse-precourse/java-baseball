package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class CreateRandomNumberTest {

    @Test
    void getComputerAnswer() {
        List<Integer> computerAnswer = CreateRandomNumber.getComputerAnswer();
        int numberCount = computerAnswer.size();
        assertThat(numberCount).isEqualTo(3);
        for (Integer integer : computerAnswer) {
            assertThat(integer).isBetween(1, 9);
        }
        Set<Integer> overlapCheck = new HashSet<>(computerAnswer);
        assertThat(numberCount).isEqualTo(overlapCheck.size());
    }
}