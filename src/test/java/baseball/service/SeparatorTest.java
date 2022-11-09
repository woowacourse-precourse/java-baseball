package baseball.service;

import baseball.entity.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class SeparatorTest {
    Separator separator = new Separator("123");

    @Test
    @DisplayName("정답과 숫자 일부분을 비교하는 테스트")
    void compareToPartOfNumber_strike() {           // 93ms
        Type correct = separator.forTest_checkCurrentCondition("1", 0);
        assertThat(correct).isEqualTo(Type.STRIKE);
    }

    @Test
    @DisplayName("정답과 숫자 일부분을 비교하는 테스트")
    void compareToPartOfNumber_ball() {
        Type correct = separator.forTest_checkCurrentCondition("2", 0);
        assertThat(correct).isEqualTo(Type.BALL);
    }

    @Test
    @DisplayName("정답과 숫자 일부분을 비교하는 테스트")
    void compareToPartOfNumber_nothing() {
        Type correct = separator.forTest_checkCurrentCondition("9", 0);
        assertThat(correct).isEqualTo(Type.NOTHING);
    }

    @Test
    @DisplayName("입력한 숫자와 정답을 비교해 정확한 결과가 나오는지")
    void compareToWholeNumber_3strike() {
        Map<Type, Integer> mock = separator.separateInputResult("123");
        assertThat(mock).containsEntry(Type.BALL, 0).containsEntry(Type.STRIKE, 3).containsEntry(Type.NOTHING, 0);
    }

    @Test
    @DisplayName("입력한 숫자와 정답을 비교해 정확한 결과가 나오는지")
    void compareToWholeNumber_2ball_1strike() {
        Map<Type, Integer> mock = separator.separateInputResult("213");
        assertThat(mock).containsEntry(Type.BALL, 2).containsEntry(Type.STRIKE, 1).containsEntry(Type.NOTHING, 0);
    }

    @Test
    @DisplayName("입력한 숫자와 정답을 비교해 정확한 결과가 나오는지")
    void compareToWholeNumber_nothing() {
        Map<Type, Integer> mock = separator.separateInputResult("987");
        assertThat(mock).containsEntry(Type.BALL, 0).containsEntry(Type.STRIKE, 0).containsEntry(Type.NOTHING, 3);
    }
}