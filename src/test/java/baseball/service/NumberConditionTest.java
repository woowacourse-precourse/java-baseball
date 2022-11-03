package baseball.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NumberConditionTest {
    private NumberCondition numberCondition = new NumberCondition("123");

    @Test
    @DisplayName("자릿수가 일치하는지")
    void testDigitCorrect_true() {
        boolean mock = numberCondition.isDigitCorrect("1", 0);
        assertThat(mock).isTrue();
    }
    @Test
    @DisplayName("자릿수가 일치하는지")
    void testDigitCorrect_false() {
        boolean mock = numberCondition.isDigitCorrect("9", 0);
        assertThat(mock).isFalse();
    }
    @Test
    @DisplayName("입력값을 포함하는지")
    void testContainsNumber_true() {
        boolean mock = numberCondition.doesContain("3");
        assertThat(mock).isTrue();
    }
    @Test
    @DisplayName("입력값을 포함하는지")
    void testContainsNumber_false() {
        boolean mock = numberCondition.doesContain("9");
        assertThat(mock).isFalse();
    }

}