package baseball.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GamePrinterTest {

    private OutputStream setSystemOut() {
        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        return outputStream;
    }

    @DisplayName("전달받은 메시지를 개행없이 출력한다.")
    @Test
    void print() {
        //given
        OutputStream out = setSystemOut();
        String message = "hello";
        GamePrinter gamePrinter = GamePrinter.getInstance();

        //when
        gamePrinter.print(message);

        //then
        assertThat(out.toString()).isEqualTo(message);
    }

    @DisplayName("전달받은 메시지를 개행 포함하여 출력한다.")
    @Test
    void println() {
        //given
        OutputStream out = setSystemOut();
        String message = "hello";
        GamePrinter gamePrinter = GamePrinter.getInstance();

        //when
        gamePrinter.println(message);

        //then
        assertThat(out.toString()).isEqualTo(message + "\n");
    }

}