package baseball.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputViewTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final InputView sut = InputView.INSTANCE;

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @BeforeEach
    public void setup() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void restore() {
        System.setOut(System.out);
        output.reset();
    }

    @Test
    void 야구게임_숫자를_입력받은다음_반환한다() {
        InputStream inputStream = generateUserInput("123");
        System.setIn(inputStream);

        String baseballNumber = sut.inputBaseballNumber();
        
        assertThat(output.toString()).isEqualTo("숫자를 입력해주세요 : \n");
        assertThat(baseballNumber).isEqualTo("123");
    }
}
