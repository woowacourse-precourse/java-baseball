package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RandomNumberTest {
    @Test
    void 랜덤_넘버_예외_테스트() {
        assertThatThrownBy(() -> RandomNumber.valueOf(10)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 랜덤_넘버_생성_테스트() {
        assertThat(RandomNumber.valueOf(7)).isInstanceOf(RandomNumber.class);
    }
}
