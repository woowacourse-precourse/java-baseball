package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

public class BaseballGameNumberTest {
    @Test
    public void 같은_수가_포함되는_경우() {
        assertThatThrownBy(() -> new BaseballGameNumber(List.of(3, 3, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("같은 수는 중복될 수 없습니다.");
    }

    @Test
    public void 범위_밖의_수가_포함되는_경우() {
        assertThatThrownBy(() -> new BaseballGameNumber(List.of(0, 4, 8)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("범위 밖의 숫자가 포함되어 있습니다.");
    }

    @Test
    public void 세자리_수가_아닌_경우() {
        assertThatThrownBy(() -> new BaseballGameNumber(List.of(1,2,3,4,5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3자리 숫자만 가능합니다.");
    }

    @Test
    public void isSame_메서드로_같은_수인지_확인() {
        BaseballGameNumber number = new BaseballGameNumber(List.of(6, 7, 8));
        BaseballGameNumber otherNumber = new BaseballGameNumber(List.of(6, 7, 8));

        boolean result = BaseballGameNumber.isSame(number, otherNumber);

        assertThat(result).isTrue();
    }

    @Test
    public void isSame_메서드_사용시_두_수가_서로_다른_경우_false를_반환() {
        BaseballGameNumber number = new BaseballGameNumber(List.of(4, 5, 6));
        BaseballGameNumber otherNumber = new BaseballGameNumber(List.of(6, 7, 8));

        boolean result = number.equals(otherNumber);

        assertThat(result).isFalse();
    }
}
