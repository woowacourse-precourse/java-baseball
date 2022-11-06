package baseball.domain.number;

import org.junit.jupiter.api.Test;

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

    @Test
    void 음수를_입력하면_예외를_던진다() {
        int inputValue = -1;

        assertThatThrownBy(() -> new SingleNumber(0, inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("양수만 입력해 주세요.");
    }

    @Test
    void 숫자_0을_포함하면_예외를_던진다() {
        assertThatThrownBy(() -> new SingleNumber(0, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0은 입력할 수 없습니다.");
    }


}