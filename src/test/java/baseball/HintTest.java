package baseball;

import baseball.model.Hint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HintTest {
    Hint hint;

    @BeforeEach
    void setUp() {
        hint = new Hint();
    }

    @Test
    void 입력받은_수를_판별하여_올바른_힌트문구를_반환한다() {
        List<Integer> computerNumbers = new ArrayList<>(Arrays.asList(4, 2, 5));

        hint.setCount(computerNumbers, Arrays.asList(1, 2, 3));
        assertEquals(hint.getMessage(), "1스트라이크");

        hint.setCount(computerNumbers, Arrays.asList(4, 5, 6));
        assertEquals(hint.getMessage(), "1볼 1스트라이크");

        hint.setCount(computerNumbers, Arrays.asList(7, 8, 9));
        assertEquals(hint.getMessage(), "낫싱");
    }

    @Test
    void 게임종료_조건에_해당하는지_확인한다() {
        List<Integer> computerNumbers = new ArrayList<>(Arrays.asList(1, 2, 3));
        hint.setCount(computerNumbers, Arrays.asList(1, 2, 3));

        assertTrue(hint.isMaxStrike());
    }
}
