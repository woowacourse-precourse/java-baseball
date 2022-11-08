package baseball.domain.player;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


class PlayerTest {
    Player player;

    @BeforeEach
    void init() {
        player = new Player();
    }

    @Test
    @DisplayName("입력받은 문자열을 정수타입으로 반환한다")
    void 문자열_입력_테스트() {
        String input = "123";
        systemSetInput(input);
        player.setInputNumbers(input);

        assertThat(player.getInputNumbers()).isEqualTo(List.of(1, 2, 3));
    }

    @Test
    @DisplayName("입력받은 문자열에 문자가 포함되어있다면 예외 발생한다")
    void 문자열_예외_테스트() {
        String input = "12앗";
        systemSetInput(input);

        Assertions.assertThatThrownBy(() -> player.setInputNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("각각 문자에 0이 포함되어있다면 예외 발생한다")
    void 문자열_범위_예외_테스트() {
        String input = "102";
        systemSetInput(input);

        Assertions.assertThatThrownBy(() -> player.setInputNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력받은 문자의 길이가 3이 아니라면 예외가 발생한다")
    void 문자열_길이_예외_테스트() {
        String input = "10234";
        systemSetInput(input);

        Assertions.assertThatThrownBy(() -> player.setInputNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력받은 문자가 중복이 된다면 예외가 발생한다")
    void 중복_입력_테스트() {
        String input = "222";
        systemSetInput(input);

        Assertions.assertThatThrownBy(() -> player.setInputNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    void systemSetInput(String input) {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}