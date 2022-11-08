package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import baseball.utils.NumberGeneratorImpl;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CatcherTest {

    private final static Integer DIGIT_LOWER_BOUND = 1;
    private final static Integer DIGIT_UPPER_BOUND = 9;
    private final static Integer ANS_SIZE = 3;
    private Catcher catcher;


    @Test
    @DisplayName("볼 카운팅")
    void catchBallTest() {
        catcher = new Catcher(() -> Arrays.asList(3, 2, 1));
        GameResult gameResult = catcher.catching(new Integer[]{1, 2, 3});
        assertEquals(gameResult.getBallCount(), 2);
    }

    @Test
    @DisplayName("스트라이크 카운팅")
    void catchCountTest() {
        catcher = new Catcher(() -> Arrays.asList(3, 2, 1));
        GameResult gameResult = catcher.catching(new Integer[]{1, 2, 3});
        assertEquals(gameResult.getStrikeCount(), 1);
    }

    @Test
    @DisplayName("올바른 정답 생성")
    void validAnswer() {
        catcher = new Catcher(new NumberGeneratorImpl());
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
