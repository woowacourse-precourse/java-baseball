package baseball;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class UserInterfaceTest {
    @Test
    void 결과_출력_테스트() {
        assertThat(UserInterface.resultOutput(3, 0)).isEqualTo(true);
        assertThat(UserInterface.resultOutput(1, 1)).isEqualTo(false);
        assertThat(UserInterface.resultOutput(1, 0)).isEqualTo(false);
        assertThat(UserInterface.resultOutput(0, 1)).isEqualTo(false);
        assertThat(UserInterface.resultOutput(0, 0)).isEqualTo(false);
    }
}