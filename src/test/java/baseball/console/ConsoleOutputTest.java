package baseball.console;

import baseball.console.ConsoleOutput;
import baseball.core.BallStrike;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class ConsoleOutputTest {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    PrintStream originalErr = System.err;

    ConsoleOutput messagePrinter;

    @BeforeEach
    void init() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        messagePrinter = new ConsoleOutput();
    }

    @Nested
    @DisplayName("게임 시작 메세지 출력")
    class PrintStartMessageTest {
        @Test
        @DisplayName("게임 시작 메세지 출력")
        void printStartMessageTest() {
            //given
            String expect = "숫자 야구 게임을 시작합니다.\n";

            //when
            messagePrinter.printStartMessage();

            //then
            assertThat(outContent.toString()).isEqualTo(expect);
        }
    }

    @Nested
    @DisplayName("게임 시작 메세지 출력")
    class PrintInputThreeNumbersMessageTest {
        @Test
        @DisplayName("게임 시작 메세지 출력")
        void printInputThreeNumbersTest() {
            //given
            String expect = "숫자를 압력해주세요 : ";

            //when
            messagePrinter.printNumberInputMessage();

            //then
            assertThat(outContent.toString()).isEqualTo(expect);
        }
    }

    @Nested
    @DisplayName("게임 시작 메세지 출력")
    class PrintResultMessageTest {
        @Test
        @DisplayName("낫싱")
        void case1() {
            //given
            BallStrike dto = new BallStrike(0, 0);
            String expected = "낫싱\n";

            //when
            messagePrinter.printResultMessage(dto.toString());

            //then
            assertThat(outContent.toString()).isEqualTo(expected);
        }

        @Test
        @DisplayName("1볼")
        void case2() {
            //given
            BallStrike dto = new BallStrike(1, 0);
            String expected = "1볼\n";

            //when
            messagePrinter.printResultMessage(dto.toString());

            //then
            assertThat(outContent.toString()).isEqualTo(expected);
        }

        @Test
        @DisplayName("1스트라이크")
        void case3() {
            //given
            BallStrike dto = new BallStrike(0, 1);
            String expected = "1스트라이크\n";

            //when
            messagePrinter.printResultMessage(dto.toString());

            //then
            assertThat(outContent.toString()).isEqualTo(expected);
        }

        @Test
        @DisplayName("1볼 1스트라이크")
        void case4() {
            //given
            BallStrike dto = new BallStrike(1, 1);
            String expected = "1볼 1스트라이크\n";

            //when
            messagePrinter.printResultMessage(dto.toString());

            //then
            assertThat(outContent.toString()).isEqualTo(expected);
        }

        @Test
        @DisplayName("2볼 1스트라이크")
        void case5() {
            //given
            BallStrike dto = new BallStrike(2, 1);
            String expected = "2볼 1스트라이크\n";

            //when
            messagePrinter.printResultMessage(dto.toString());

            //then
            assertThat(outContent.toString()).isEqualTo(expected);
        }

        @Test
        @DisplayName("3스트라이크")
        void case6() {
            //given
            BallStrike dto = new BallStrike(0, 3);
            String expected = "3스트라이크\n";

            //when
            messagePrinter.printResultMessage(dto.toString());

            //then
            assertThat(outContent.toString()).isEqualTo(expected);
        }
    }

    @Nested
    @DisplayName("게임 종료 메세지 출력")
    class PrintFinishMessageTest {
        @Test
        @DisplayName("게임 시작 메세지 출력")
        void printFinishMessageTest() {
            //given
            String expect = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n";

            //when
            messagePrinter.printFinishMessage();

            //then
            assertThat(outContent.toString()).isEqualTo(expect);
        }
    }

    @Nested
    @DisplayName("게임 재시작 또는 종료 메세지 출력")
    class PrintRestartOrExitMessageTest {
        @Test
        @DisplayName("메세지 출력")
        void printRestartOrExitMessageTest() {
            //given
            String expect = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";

            //when
            messagePrinter.printRestartOrExitMessage();

            //then
            assertThat(outContent.toString()).isEqualTo(expect);
        }
    }

    @AfterEach
    void reset() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

}