package baseball;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InputTest {
    Input_function Input = new Input_function();

    @Test
    void input_test() {
        String input = "523";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String out = Input.input();
        assertThat(out).isEqualTo("523");
    }
}
