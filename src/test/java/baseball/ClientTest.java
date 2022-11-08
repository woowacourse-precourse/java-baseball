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
class ClientTest {

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
        Client.showGameStartMessage();
        assertThat(output()).isEqualTo("숫자 야구 게임을 시작합니다.");
    }

    @Nested
    @DisplayName("게임숫자를_맞출_숫자에_대한_입력_요청_기능에서")
    class AskInputNumberTest {

        @Test
        void 정상_입력은_에러를_던지지_않고_정상작동한다() {
            input("321");
            int expected = 321;
            int actual = Client.askPlayerGameNumber();
            assertThat(output()).isEqualTo("숫자를 입력해주세요 : ");
            assertThat(actual).isEqualTo(expected);
        }

        @Test
        void 입력이_문자라면_IllegalArgumentException이_발생한다() {
            input("간다스");
            assertThatThrownBy(
                Client::askPlayerGameNumber
            ).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 입력이_4글자_이상이면_IllegalArgumentException이_발생한다() {
            input("4321");
            assertThatThrownBy(
                Client::askPlayerGameNumber
            ).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 입력이_0글자_이하라면_IllegalArgumentException이_발생한다() {
            input("");
            assertThatThrownBy(
                Client::askPlayerGameNumber
            ).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 입력에_중복된_숫자가_있다면_IllegalArgumentException이_발생한다() {
            input("424");
            assertThatThrownBy(
                Client::askPlayerGameNumber
            ).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 공백문자만_입력되면_IllegalArgumentException이_발생한다() {
            input(" ");
            assertThatThrownBy(
                Client::askPlayerGameNumber
            ).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 숫자와_공백이_같이_입력되면_IllegalArgumentException이_발생한다() {
            input("123 ");
            assertThatThrownBy(
                Client::askPlayerGameNumber
            ).isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("플레이어 숫자와 정답숫자와 비교한 결과 출력")
    class ShowJudgedResultTest {

        @Test
        void 결과가_3스트라이크로_주어지면_그대로_정상출력한다() {
            JudgedResultDto judgedResultDto = new JudgedResultDto();
            judgedResultDto.countBalls = 0;
            judgedResultDto.countStrikes = 3;

            Client.showJudgedResult(judgedResultDto);

            assertThat(output()).isEqualTo("3스트라이크");
        }

        @Test
        void 결과가_2스트라이크로_주어지면_그대로_정상출력한다() {
            JudgedResultDto judgedResultDto = new JudgedResultDto();
            judgedResultDto.countBalls = 0;
            judgedResultDto.countStrikes = 2;

            Client.showJudgedResult(judgedResultDto);

            assertThat(output()).isEqualTo("2스트라이크");
        }

        @Test
        void 결과가_2볼_1스트라이크로_주어지면_그대로_정상출력한다() {
            JudgedResultDto judgedResultDto = new JudgedResultDto();
            judgedResultDto.countBalls = 2;
            judgedResultDto.countStrikes = 1;

            Client.showJudgedResult(judgedResultDto);

            assertThat(output()).isEqualTo("2볼 1스트라이크");
        }

        @Test
        void 결과가_3볼로_주어지면_그대로_정상출력한다() {
            JudgedResultDto judgedResultDto = new JudgedResultDto();
            judgedResultDto.countBalls = 3;
            judgedResultDto.countStrikes = 0;

            Client.showJudgedResult(judgedResultDto);

            assertThat(output()).isEqualTo("3볼");
        }

        @Test
        void 결과가_낫싱으로_주어지면_그대로_정상출력한다() {
            JudgedResultDto judgedResultDto = new JudgedResultDto();
            judgedResultDto.countBalls = 0;
            judgedResultDto.countStrikes = 0;

            Client.showJudgedResult(judgedResultDto);

            assertThat(output()).isEqualTo("낫싱");
        }
    }

    @Test
    void 게임_종료_메시지는_출력스트림에_정상_저장된다() {
        Client.showGameEndMessage();
        assertThat(output()).isEqualTo("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    @Nested
    @DisplayName("새로운 게임 시작 여부에 대한 입력 요청 기능에서")
    class AskMoreGameTest {

        @Test
        void 한_게임_더_할지_묻는_메시지가_정상출력되고_한_게임_더_한다() {
            input("1");
            boolean expected = true;
            boolean actual = Client.askMoreGame();
            assertThat(actual).isEqualTo(expected);
            assertThat(output()).isEqualTo("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }

        @Test
        void 게임을_더이상_하지_않는다() {
            input("2");
            boolean expected = false;
            boolean actual = Client.askMoreGame();
            assertThat(actual).isEqualTo(expected);
        }

        @Test
        void 문자가_입력되어_IllegalArgumentException으로_처리한다() {
            input("문자");
            assertThatThrownBy(
                Client::askMoreGame
            ).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 숫자1이나_2말고_다른_숫자가_입력되어_IllegalArgumentException으로_처리한다() {
            input("5");
            assertThatThrownBy(
                Client::askMoreGame
            ).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 입력으로_받아온_값이_없는_경우에는_IllegalArgumentException으로_처리한다() {
            input("");
            assertThatThrownBy(
                Client::askMoreGame
            ).isInstanceOf(IllegalArgumentException.class);
        }
    }
}