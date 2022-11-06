package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("출력 메시지 및 입력 관리 기능 테스트")
class NumberBaseballGameClientTest {

    private PrintStream standardOut;
    private OutputStream captor;
    private InputStream standardIn;

    @BeforeEach
    protected final void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
        standardIn = System.in;
    }

    @AfterEach
    protected final void printOutput() {
        System.setOut(standardOut);
        System.setIn(standardIn);
        System.out.println(output());
    }

    protected final String output() {
        return captor.toString().replaceAll("(\r\n|\r|\n|\n\r)", "");
    }

    private void input(final String... args) {
        final byte[] buffer = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buffer));
    }

    @Test
    void 게임_시작_메시지는_출력스트림에_정상_저장된다() {
        NumberBaseballGameClient.showGameStartMessage();
        assertThat(output()).isEqualTo("숫자 야구 게임을 시작합니다.");
    }

    @Nested
    @DisplayName("게임숫자를_맞출_숫자에_대한_입력_요청_기능에서")
    class AskInputNumberTest {
        @Test
        void 정상_입력은_에러를_던지지_않고_정상작동한다() {
            input("321");
            int expected = 321;
            int actual = NumberBaseballGameClient.askPlayerGameNumber();
            assertThat(output()).isEqualTo("숫자를 입력해주세요 : ");
            assertThat(actual).isEqualTo(expected);
        }

        @Test
        void 입력이_문자라면_IllegalArgumentException이_발생한다() {
            input("간다스");
            assertThatThrownBy(
                NumberBaseballGameClient::askPlayerGameNumber
            ).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 입력이_4글자_이상이면_IllegalArgumentException이_발생한다() {
            input("4321");
            assertThatThrownBy(
                NumberBaseballGameClient::askPlayerGameNumber
            ).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 입력이_0글자_이하라면_IllegalArgumentException이_발생한다() {
            input("");
            assertThatThrownBy(
                NumberBaseballGameClient::askPlayerGameNumber
            ).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 입력에_중복된_숫자가_있다면_IllegalArgumentException이_발생한다() {
            input("424");
            assertThatThrownBy(
                NumberBaseballGameClient::askPlayerGameNumber
            ).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 공백문자만_입력되면_IllegalArgumentException이_발생한다() {
            input(" ");
            assertThatThrownBy(
                NumberBaseballGameClient::askPlayerGameNumber
            ).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 숫자와_공백이_같이_입력되면_IllegalArgumentException이_발생한다() {
            input("123 ");
            assertThatThrownBy(
                NumberBaseballGameClient::askPlayerGameNumber
            ).isInstanceOf(IllegalArgumentException.class);
        }
    }
}