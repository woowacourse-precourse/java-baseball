package baseball.view;

import baseball.view.message.GameMessage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class ViewTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void afterEach() {
        System.setOut(System.out);
        outputStream.reset();
    }

    @Test
    @DisplayName("View의 start() 출력 메시지 테스트")
    void start() {
        // given
        String expectedValue = "숫자 야구 게임을 시작합니다.\n";

        // when
        View.start();

        // then
        assertThat(expectedValue).isEqualTo(outputStream.toString());
    }

    @Test
    @DisplayName("pushNumber() 출력 메시지 테스트")
    void pushNumber() {
        // given
        String expectedValue = "숫자를 입력하세요 : ";

        // when
        View.pushNumber();

        // then
        assertThat(expectedValue).isEqualTo(outputStream.toString());
    }

    @Test
    @DisplayName("end() 출력 메시지 테스트")
    void end() {
        // given
        String expectedValue = "3스트라이크\n"
                + GameMessage.END.getMessage()
                + "\n" + GameMessage.RESTART_OR_END.getMessage()
                + "\n";

        // when
        View.end();

        // then
        assertThat(expectedValue).isEqualTo(outputStream.toString());
    }

    @Test
    @DisplayName("ballAndStrike() 출력 메시지 테스트")
    void ballAndStrike() {
        // given
        String expectedValue = "2볼 1스트라이크\n";

        // when
        View.ballAndStrike(2, 1);

        // then
        assertThat(expectedValue).isEqualTo(outputStream.toString());
    }

    @Test
    @DisplayName("ball() 출력 메시지 테스트")
    void ball() {
        // given
        String expectedValue = "2볼\n";

        // when
        View.ball(2);

        // then
        assertThat(expectedValue).isEqualTo(outputStream.toString());
    }

    @Test
    @DisplayName("strike() 출력 메시지 테스트")
    void strike() {
        // given
        String expectedValue = "1스트라이크\n";

        // when
        View.strike(1);

        // then
        assertThat(expectedValue).isEqualTo(outputStream.toString());
    }

    @Test
    @DisplayName("nothing() 출력 메시지 테스트")
    void nothing() {
        // given
        String expectedValue = "낫싱\n";

        // when
        View.nothing();

        // then
        assertThat(expectedValue).isEqualTo(outputStream.toString());
    }
}