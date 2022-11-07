package study;

import baseball.RandomNumber;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RandomNumberTest {

    @Test
    public void 랜덤_숫자_길이_3() {
        List<Integer> numbers = RandomNumber.generate();
        assertThat(3).isEqualTo(numbers.size());
    }

    @Test
    public void 랜덤_숫자_범위_1부터_9() {
        List<Integer> numbers = RandomNumber.generate();
        assertThat(numbers.get(0)).isBetween(1, 9);
        assertThat(numbers.get(1)).isBetween(1, 9);
        assertThat(numbers.get(2)).isBetween(1, 9);
    }

    @Test
    public void 랜덤_숫자_중복_없음() {
        List<Integer> numbers = RandomNumber.generate();
        assertThat(numbers.get(0)).isNotEqualTo(numbers.get(1));
        assertThat(numbers.get(0)).isNotEqualTo(numbers.get(2));
        assertThat(numbers.get(1)).isNotEqualTo(numbers.get(2));
    }

}
