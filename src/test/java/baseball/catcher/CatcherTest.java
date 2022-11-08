package baseball.catcher;

import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.GameResult;
import baseball.catcher.Catcher;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CatcherTest {

    private final static Integer DIGIT_LOWER_BOUND = 1;
    private final static Integer DIGIT_UPPER_BOUND = 9;
    private final static Integer ANS_SIZE = 3;
    private Catcher catcher;


    @Test
    @DisplayName("볼 카운팅")
    void countingBallTest() {
        catcher = new Catcher(() -> Arrays.asList(3, 2, 1));
        catcher.initRandomNumbers();
        GameResult gameResult = catcher.catching(new Integer[]{1, 2, 3});
        assertEquals(2, gameResult.getBallCount());
    }

    @Test
    @DisplayName("스트라이크 카운팅")
    void countingStrikeTest() {
        catcher = new Catcher(() -> Arrays.asList(3, 2, 1));
        catcher.initRandomNumbers();
        GameResult gameResult = catcher.catching(new Integer[]{1, 2, 3});
        assertEquals(1, gameResult.getStrikeCount());
    }

    /**
     * 정보 은닉을 위해 catcher.getAnswer() 메서드 삭제
     */
    /*
    @Test
    @DisplayName("올바른 정답 생성")
    void validAnswer() {
        catcher = new Catcher(new NumberGeneratorImpl());
        catcher.initRandomNumbers();
        assertTrue(check(catcher.getAnswer()));
    }

    private boolean check(final List<Integer> answer) {
        return checkLength(answer) && checkDupDigit(answer) && checkRange(answer);
    }

    private boolean checkRange(final List<Integer> answer) {
        int invalidDigitCount = 0;
        for (Integer digit : answer) {
            invalidDigitCount += isInInValidRange(digit);
        }
        if (invalidDigitCount > 0) {
            return false;
        }
        return true;
    }

    private int isInInValidRange(Integer digit) {
        if (DIGIT_LOWER_BOUND <= digit && digit <= DIGIT_UPPER_BOUND) {
            return 0;
        }
        return 1;
    }

    private boolean checkDupDigit(final List<Integer> answer) {
        Set<Integer> digitSet = new HashSet<>(answer);
        return ANS_SIZE.equals(digitSet.size());
    }

    private boolean checkLength(final List<Integer> answer) {
        return ANS_SIZE.equals(answer.size());
    }
    */
}
