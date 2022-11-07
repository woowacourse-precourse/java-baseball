package baseball.view;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.Number;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

public class OutputTest {
    private Output output;

    @Test
    void 출력_테스트() {
        Number number = new Number(1, 0);
        output = new Output(number);

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        output.printOutput();
        assertThat(out.toString()).isEqualTo("1스트라이크\n");
    }

    @Test
    void 낫싱_테스트() {
        Number number = new Number();
        output = new Output(number);

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        output.printOutput();
        assertThat(out.toString()).isEqualTo("낫싱\n");
    }
}
