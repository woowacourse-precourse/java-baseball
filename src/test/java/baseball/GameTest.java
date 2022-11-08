package baseball;


import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameTest {

    @ParameterizedTest
    @ValueSource(strings = {"11", "22"})
    void 재시작_입력_예외_테스트() {
        Game game = new Game();

        String input = "b";

        assertThrows(IllegalArgumentException.class, () -> {
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            game.wantRestart();
        });
    }


}