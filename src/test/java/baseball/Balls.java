package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class Balls {
    @Test
    void 같은_숫자_같은_위치_스트라이크_확인하기() {
        Balls computer = new Balls(135);

        assertThat(computer.compare(2, 3)).isTrue();
    }
}
