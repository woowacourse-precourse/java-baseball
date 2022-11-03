package baseball.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("OutputView 클래스")
@SuppressWarnings({"InnerClassMayBeStatic", "NonAsciiCharacters"})
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
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

    @Nested
    class startBaseballGame_메서드는 {

        @Nested
        class 숫자_야구_게임을_시작합니다_라는_문자를 {
            private final String consolePrint = "숫자 야구 게임을 시작합니다.\n";

            @Test
            void 화면에_출력한다() {
                sut.startBaseballGame();
                assertThat(output.toString()).isEqualTo(consolePrint);
            }
        }
    }

}
