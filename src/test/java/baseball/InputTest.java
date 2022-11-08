package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InputTest {
    static String RESTART_GAME = "1";
    static String END_GAME = "2";

    @DisplayName("Input: inGame에서 string input을 받아 character list로 잘 쪼개는지 확인")
    @Test
    void inputInGame() {
        byte[] buf = "123".getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        List<Character> input = Input.getInputInGame();
        assertThat(input).isEqualTo(List.of('1', '2', '3'));
    }

    @DisplayName("Input: endGame에서 string input을 받아 character로 반환하는지 확인(1이나 2의 경우만 테스트)")
    @Test
    void inputEndGame() {
        byte[] bufRestart = RESTART_GAME.getBytes();
        System.setIn(new ByteArrayInputStream(bufRestart));
        char inputRestart = Input.getInputEndGame();

        byte[] bufEnd = END_GAME.getBytes();
        System.setIn(new ByteArrayInputStream(bufEnd));
        char inputEnd = Input.getInputEndGame();

        assertThat(inputRestart).isEqualTo('1');
        assertThat(inputEnd).isEqualTo('2');
    }
}
