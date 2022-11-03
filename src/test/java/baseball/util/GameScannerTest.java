package baseball.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameScannerTest {

    private void setSystemInput(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }

    @DisplayName("입력을 올바르게 반환하는지 확인한다.")
    @Test
    void returnCorrectInputString() {
        //given
        String input = "123";
        setSystemInput(input);
        GameScanner gameScanner = GameScanner.getInstance();

        //when
        String result = gameScanner.next();

        //then
        assertThat(result).isEqualTo(input);
    }

}