package baseball.service;

import baseball.entity.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ConditionTest {
    private Condition condition = new Condition("123");

    @Test
    @DisplayName("자릿수가 일치하는지")
    void testDigitCorrect_true() {
        boolean mock = condition.isDigitCorrect("1", 0);
        assertThat(mock).isTrue();
    }

    @Test
    @DisplayName("자릿수가 일치하는지")
    void testDigitCorrect_false() {             // 100ms
        boolean mock = condition.isDigitCorrect("9", 0);
        assertThat(mock).isFalse();
    }

    @Test
    @DisplayName("입력값을 포함하는지")
    void testContainsNumber_true() {
        boolean mock = condition.doesContain("3");
        assertThat(mock).isTrue();
    }

    @Test
    @DisplayName("입력값을 포함하는지")
    void testContainsNumber_false() {
        boolean mock = condition.doesContain("9");
        assertThat(mock).isFalse();
    }

}