package baseball.domain.number;

import baseball.domain.SingleNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SingleNumberTest {

    @Test
    void 정답_숫자_리스트_안에_ball의_조건을_만족하는_SingleNumber가_있을_경우_1을_반환한다() {
        SingleNumber singleNumber = new SingleNumber(0, 1);
        List<SingleNumber> answer = List.of(
                new SingleNumber(0, 2),
                new SingleNumber(1, 1),
                new SingleNumber(2, 3)
        );

        int result = singleNumber.judgeBall(answer);
        assertThat(result).isEqualTo(1);
    }

    @Test
    void 정답_숫자_리스트_안에_ball의_조건을_만족하는_SingleNumber가_없을_경우_0을_반환한다() {
        SingleNumber singleNumber = new SingleNumber(0, 1);
        List<SingleNumber> answer = List.of(
                new SingleNumber(0, 2),
                new SingleNumber(1, 4),
                new SingleNumber(2, 3)
        );

        int result = singleNumber.judgeBall(answer);
        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 10, -1})
    void 입력된_숫자가_1_부터_9_범위를_벗어나면_예외를_던진다(int inputValue) {
        assertThatThrownBy(() -> new SingleNumber(0, inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력 숫자의 범위는 1~9 입니다.");
    }


}