package baseball.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class SeparationTest {
    Separation separation = new Separation("123");

    @Test
    @DisplayName("정답과 숫자 일부분을 비교하는 테스트")
    void compareToPartOfNumber_strike() {           // 93ms
        String correct = separation.copyCheckCurrentConditionForTest("1", 0);
        assertThat(correct).isEqualTo("strike");
    }
    @Test
    @DisplayName("정답과 숫자 일부분을 비교하는 테스트")
    void compareToPartOfNumber_ball() {
        String correct = separation.copyCheckCurrentConditionForTest("2", 0);
        assertThat(correct).isEqualTo("ball");
    }
    @Test
    @DisplayName("정답과 숫자 일부분을 비교하는 테스트")
    void compareToPartOfNumber_nothing() {
        String correct = separation.copyCheckCurrentConditionForTest("9", 0);
        assertThat(correct).isEqualTo("nothing");
    }

    @Test
    @DisplayName("입력한 숫자와 정답을 비교해 정확한 결과가 나오는지")
    void compareToWholeNumber_3strike() {
        Map<String, Integer> mock = separation.separateInputResult("123");
        assertThat(mock).containsEntry("ball",0).containsEntry("strike",3).containsEntry("nothing",0);
    }
    @Test
    @DisplayName("입력한 숫자와 정답을 비교해 정확한 결과가 나오는지")
    void compareToWholeNumber_2ball_1strike() {
        Map<String, Integer> mock = separation.separateInputResult("213");
        assertThat(mock).containsEntry("ball",2).containsEntry("strike",1).containsEntry("nothing",0);
    }
    @Test
    @DisplayName("입력한 숫자와 정답을 비교해 정확한 결과가 나오는지")
    void compareToWholeNumber_nothing() {
        Map<String, Integer> mock = separation.separateInputResult("987");
        assertThat(mock).containsEntry("ball",0).containsEntry("strike",0).containsEntry("nothing",3);
    }
}