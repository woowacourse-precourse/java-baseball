package baseball.domain.baseballnumber;

import static baseball.domain.baseballnumber.BaseballNumberListGenerator.baseballNumberList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BaseballNumberTest {

    @DisplayName("정답 숫자 리스트 안에 ball의 조건을 만족하는 SingleNumber가 있을 경우 1을 반환한다")
    @Test
    void ballTest1() {
        BaseballNumber baseballNumber = new BaseballNumber(0, 1);
        List<BaseballNumber> answer = baseballNumberList("213");

        assertThat(baseballNumber.equalsOnlyNumber(answer)).isTrue();
    }

    @DisplayName("정답 숫자 리스트 안에 ball의 조건을 만족하는 SingleNumber가 없을 경우 0을 반환한다")
    @Test
    void ballTest2() {
        BaseballNumber baseballNumber = new BaseballNumber(0, 1);
        List<BaseballNumber> answer = baseballNumberList("243");

        assertThat(baseballNumber.equalsOnlyNumber(answer)).isFalse();
    }

    @ParameterizedTest(name = "입력된 숫자가 1 부터 9 범위를 벗어나면 예외를_던진다")
    @ValueSource(ints = {0, 10, -1})
    void exceptionTest(int inputValue) {
        assertThatThrownBy(() -> new BaseballNumber(0, inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력 숫자의 범위는 1~9 입니다.");
    }
}