package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BaseBallNumberTest {

    @Test
    public void 베이스볼_숫자_생성() {
        BaseBallNumber of = BaseBallNumber.of(List.of(1, 2, 3));
        assertThat(of.getNumber()).isEqualTo(List.of(1, 2, 3));
    }

    @Test
    public void 베이스볼_숫자_생성_실패케이스1() {
        assertThatThrownBy(() -> BaseBallNumber.of(List.of(1, 2, 2))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 베이스볼_숫자_생성_실패케이스2() {
        assertThatThrownBy(() -> BaseBallNumber.of(List.of(1, 2, 3, 4))).isInstanceOf(IllegalArgumentException.class);
    }
}
