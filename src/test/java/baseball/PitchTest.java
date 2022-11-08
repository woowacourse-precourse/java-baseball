package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class PitchTest extends NsTest {
    Pitch pitch;
    @Test
    public void generate() {
        run("246");
        assertThat(pitch.getNumber(0)).isEqualTo(2);
        assertThat(pitch.getNumber(1)).isEqualTo(4);
        assertThat(pitch.getNumber(2)).isEqualTo(6);
    }

    @Test
    public void IllegalGenerate() {
        assertThatThrownBy(()->runException("24s")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void IllegalGenerateWithSpace() {
        assertThatThrownBy(()->runException("24 ")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void IllegalGenerateWithZero() {
        assertThatThrownBy(()->runException("240")).isInstanceOf(IllegalArgumentException.class);
    }
    @Override
    protected void runMain() {
        pitch = new Pitch();
    }
}