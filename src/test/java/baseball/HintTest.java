package baseball;

import baseball.model.Hint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HintTest {
    Hint hint;
    List<Integer> computerNumbers;

    @BeforeEach
    void setUp() {
        hint = new Hint();
        computerNumbers = new ArrayList<>(Arrays.asList(4, 2, 5));
    }

    @Test
    void 입력받은_수에_따라_힌트문구를_반환한다_1스트라이크() {
        hint.setCount(computerNumbers, Arrays.asList(1, 2, 3));
        assertEquals(hint.getMessage(), "1스트라이크");
    }

    @Test
    void 입력받은_수에_따라_힌트문구를_반환한다_2스트라이크() {
        hint.setCount(computerNumbers, Arrays.asList(1, 2, 5));
        assertEquals(hint.getMessage(), "2스트라이크");
    }

    @Test
    void 입력받은_수에_따라_힌트문구를_반환한다_3스트라이크() {
        hint.setCount(computerNumbers, Arrays.asList(4, 2, 5));
        assertEquals(hint.getMessage(), "3스트라이크");
    }

    @Test
    void 입력받은_수에_따라_힌트문구를_반환한다_1볼() {
        hint.setCount(computerNumbers, Arrays.asList(1, 5, 3));
        assertEquals(hint.getMessage(), "1볼");
    }

    @Test
    void 입력받은_수에_따라_힌트문구를_반환한다_2볼() {
        hint.setCount(computerNumbers, Arrays.asList(2, 4, 9));
        assertEquals(hint.getMessage(), "2볼");
    }

    @Test
    void 입력받은_수에_따라_힌트문구를_반환한다_3볼() {
        hint.setCount(computerNumbers, Arrays.asList(5, 4, 2));
        assertEquals(hint.getMessage(), "3볼");
    }

    @Test
    void 입력받은_수에_따라_힌트문구를_반환한다_1볼_1스트라이크() {
        hint.setCount(computerNumbers, Arrays.asList(1, 2, 4));
        assertEquals(hint.getMessage(), "1볼 1스트라이크");
    }

    @Test
    void 입력받은_수에_따라_힌트문구를_반환한다_1볼_2스트라이크() {
        hint.setCount(computerNumbers, Arrays.asList(5, 2, 4));
        assertEquals(hint.getMessage(), "2볼 1스트라이크");
    }

    @Test
    void 입력받은_수에_따라_힌트문구를_반환한다_낫싱() {
        hint.setCount(computerNumbers, Arrays.asList(7, 8, 9));
        assertEquals(hint.getMessage(), "낫싱");
    }

    @Test
    void 게임종료_조건에_해당한다() {
        hint.setCount(computerNumbers, Arrays.asList(4, 2, 5));
        assertTrue(hint.isMaxStrike());
    }

    @Test
    void 게임종료_조건에_해당하지_않는다() {
        hint.setCount(computerNumbers, Arrays.asList(1, 2, 5));
        assertFalse(hint.isMaxStrike());
    }
}
