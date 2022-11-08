package baseball.domain.baseball_number;

import static baseball.domain.baseball_number.BaseballNumberListGenerator.baseballNumberList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BaseballNumberTest {

    @Test
    void 정답_숫자_리스트_안에_ball의_조건을_만족하는_SingleNumber가_있을_경우_1을_반환한다() {
        BaseballNumber baseballNumber = new BaseballNumber(0, 1);
        List<BaseballNumber> answer = baseballNumberList("213");

        assertThat(baseballNumber.equalsOnlyNumber(answer)).isTrue();
    }

    @Test
    void 정답_숫자_리스트_안에_ball의_조건을_만족하는_SingleNumber가_없을_경우_0을_반환한다() {
        BaseballNumber baseballNumber = new BaseballNumber(0, 1);
        List<BaseballNumber> answer = baseballNumberList("243");

        assertThat(baseballNumber.equalsOnlyNumber(answer)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 10, -1})
    void 입력된_숫자가_1_부터_9_범위를_벗어나면_예외를_던진다(int inputValue) {
        assertThatThrownBy(() -> new BaseballNumber(0, inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력 숫자의 범위는 1~9 입니다.");
    }


}