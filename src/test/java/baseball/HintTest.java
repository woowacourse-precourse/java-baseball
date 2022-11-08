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
    void 입력받은_수를_판별하여_올바른_힌트문구를_반환한다_스트라이크() {
        List<Integer> computerNumbers = new ArrayList<>(Arrays.asList(4, 2, 5));

        hint.setCount(computerNumbers, Arrays.asList(1, 2, 3));
        assertEquals(hint.getMessage(), "1스트라이크");

        hint.setCount(computerNumbers, Arrays.asList(1, 2, 5));
        assertEquals(hint.getMessage(), "2스트라이크");

        hint.setCount(computerNumbers, Arrays.asList(4, 2, 5));
        assertEquals(hint.getMessage(), "3스트라이크");
    }

    @Test
    void 입력받은_수를_판별하여_올바른_힌트문구를_반환한다_볼() {
        List<Integer> computerNumbers = new ArrayList<>(Arrays.asList(4, 2, 5));

        hint.setCount(computerNumbers, Arrays.asList(1, 5, 3));
        assertEquals(hint.getMessage(), "1볼");

        hint.setCount(computerNumbers, Arrays.asList(2, 4, 9));
        assertEquals(hint.getMessage(), "2볼");

        hint.setCount(computerNumbers, Arrays.asList(5, 4, 2));
        assertEquals(hint.getMessage(), "3볼");
    }

    @Test
    void 입력받은_수를_판별하여_올바른_힌트문구를_반환한다_볼_스트라이크() {
        List<Integer> computerNumbers = new ArrayList<>(Arrays.asList(4, 2, 5));

        hint.setCount(computerNumbers, Arrays.asList(1, 2, 4));
        assertEquals(hint.getMessage(), "1볼 1스트라이크");

        hint.setCount(computerNumbers, Arrays.asList(5, 2, 4));
        assertEquals(hint.getMessage(), "2볼 1스트라이크");
    }

    @Test
    void 입력받은_수를_판별하여_올바른_힌트문구를_반환한다_낫싱() {
        List<Integer> computerNumbers = new ArrayList<>(Arrays.asList(4, 2, 5));

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
