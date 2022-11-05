package baseball.domain.number;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SingleNumberTest {

    @Test
    void 정답_숫자_리스트_안에_ball의_조건을_만족하는_SingleNumber가_있을_경우_1을_반환한다() {
        SingleNumber singleNumber = new SingleNumber(0, 1);
        List<SingleNumber> answer = List.of(
                new SingleNumber(0, 2),
                new SingleNumber(1, 1),
                new SingleNumber(2, 3)
        );

        int result = singleNumber.countBall(answer);
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

        int result = singleNumber.countBall(answer);
        assertThat(result).isEqualTo(0);
    }
}