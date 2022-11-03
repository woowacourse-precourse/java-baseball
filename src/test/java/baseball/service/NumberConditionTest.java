package baseball.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NumberConditionTest {
    private NumberCondition numberCondition = new NumberCondition("123");

    @Test
    @DisplayName("몇 개의 숫자가 포함되는지")
    void count_how_many_contain_number() {
        int correct1 = numberCondition.countContainmentRightness("192");
        int correct2 = numberCondition.countContainmentRightness("375");
        int correct3 = numberCondition.countContainmentRightness("231");

        assertThat(correct1).isEqualTo(2);
        assertThat(correct2).isEqualTo(1);
        assertThat(correct3).isEqualTo(3);
    }

    @Test
    @DisplayName("자릿수가 몇 개가 일치하는지")
    void count_how_many_correct_digit() {
        int correct1 = numberCondition.countDigitRightness("168");
        int correct2 = numberCondition.countDigitRightness("231");

        assertThat(correct1).isEqualTo(1);
        assertThat(correct2).isEqualTo(0);
    }
}