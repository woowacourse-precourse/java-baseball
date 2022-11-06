package study;

import baseball.Number;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TestCase {

    @Test
    void 컴퓨터의_각_숫자가_1부터9까지_있는지_확인() {
        Number computerNumber = new ComputerNum();
        List<Integer> num = computerNumber.createNumber();
        assertThat(num).allSatisfy(
                integer -> assertThat(integer).isBetween(1, 9));
    }

    @Test
    void 컴퓨터의_숫자간_중복이_있는지_확인() {
        Number computerNumber = new ComputerNum();
        List<Integer> num = computerNumber.createNumber();
        assertThat(num).allSatisfy(
                integer -> assertThat(integer)
        ).containsOnlyOnce(num.get(0));
    }

    @Test
    void 컴퓨터의_수가_3자리_수로_이루어져_있는지_확인() {
        Number computerNumber = new ComputerNum();
        List<Integer> num = computerNumber.createNumber();
        assertThat(num.size()).isEqualTo(3);
    }

}
