package baseball.model;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

class JudgeLogicTest {
    private JudgeLogic judgeLogic;

    @BeforeEach
    void setUp() {
        judgeLogic = new JudgeLogic();
    }

    @Test
    void countSameNumber() {
        int result = 0;
        result = judgeLogic.countSameNumber(Arrays.asList(1, 2, 3), Arrays.asList(2, 3, 4));
        assertThat(result).isEqualTo(2);
    }

    @Test
    void isSameNumber() {
        assertTrue(judgeLogic.isSameNumber(Arrays.asList(1, 2, 3), Arrays.asList(2, 4, 3), 2));
    }

    @Test
    void isSameNumber2() {
        assertFalse(judgeLogic.isSameNumber(Arrays.asList(2, 3, 4), Arrays.asList(2, 4, 3), 1));
    }
}