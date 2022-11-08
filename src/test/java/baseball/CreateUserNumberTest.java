package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class CreateUserNumberTest {

    @Test
    void userAnswer() {
        List<Integer> userInput= CreateUserNumber.userAnswer("123");
        int numberCount = userInput.size();
        assertThat(numberCount).isEqualTo(3);
        for (Integer integer : userInput) {
            assertThat(integer).isBetween(1, 9);
        }
        Set<Integer> overlapNumber = new HashSet<>(userInput);
        assertThat(numberCount).isEqualTo(overlapNumber.size());
    }
}