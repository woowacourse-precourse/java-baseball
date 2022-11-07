package baseball.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayerNumberTest {

    @Test
    void 정상적인_숫자_입력받고_파싱하기() {
        PlayerNumber playerNumber123 = new PlayerNumber("123");
        PlayerNumber playerNumber456 = new PlayerNumber(" 4 5 6 ");

        Assertions.assertThat(playerNumber123.get())
                .contains(1, 2, 3);
        Assertions.assertThat(playerNumber456.get())
                .contains(6, 5, 4);
    }
}