package baseball;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CatcherTest {

    private final static Integer DIGIT_LOWER_BOUND = 1;
    private final static Integer DIGIT_UPPER_BOUND = 9;
    private final static Integer ANS_SIZE = 3;
    private Catcher catcher = new Catcher();

    @Test
    @DisplayName("올바른 정답 생성")
    void validAnswer() {
        catcher.initRandomNumbers();
        assertTrue(check(catcher.getAnswer()));
    }

    private boolean check(final List<Integer> answer) {
        return checkLength(answer) && checkDupDigit(answer) && checkRange(answer);
    }

    private boolean checkRange(final List<Integer> answer) {
        for (Integer digit : answer) {
            if (DIGIT_LOWER_BOUND > digit || digit > DIGIT_UPPER_BOUND) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDupDigit(final List<Integer> answer) {
        Set<Integer> digitSet = new HashSet<>(answer);
        return ANS_SIZE.equals(digitSet.size());
    }

    private boolean checkLength(final List<Integer> answer) {
        return ANS_SIZE.equals(answer.size());
    }

}
