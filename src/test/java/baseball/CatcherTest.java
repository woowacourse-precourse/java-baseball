package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CatcherTest {

    @Test
    void 포수의_리스트에_중복이_없는지() {
        Catcher c = new Catcher();
        assertThat(c.getCatcherNumbers()).doesNotHaveDuplicates();
    }
}