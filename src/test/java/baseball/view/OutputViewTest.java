package baseball.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OutputViewTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final OutputView sut = OutputView.INSTANCE;

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
    void 게임을_시작하면_숫자_야구_게임을_시작합니다_라고_화면에_출력한다() {
        sut.startBaseballGame();
        assertThat(output.toString()).isEqualTo("숫자 야구 게임을 시작합니다.\n");
    }
}
