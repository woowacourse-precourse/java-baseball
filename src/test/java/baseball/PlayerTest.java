package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

class PlayerTest {

    Player player = new Player();

    @Test
    void 자릿수_초과_예외() {
        String input = "1234";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> player.getIntegerListAsInput());
        assertThat(e.getMessage()).isEqualTo("입력의 길이는 3이어야 합니다.");
    }

    @Test
    void 범위_초과_예외() {
        String input = "012";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> player.getIntegerListAsInput());
        assertThat(e.getMessage()).isEqualTo("각 자리의 범위는 1부터 9까지입니다.");
    }

    @Test
    void 숫자_중복_입력_예외() {
        String input = "121";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> player.getIntegerListAsInput());
        assertThat(e.getMessage()).isEqualTo("각 자리는 서로 달라야 합니다.");
    }
}