package baseball.printer;

import baseball.dto.BallStrikeDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class GameMessagePrinterTest {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    PrintStream originalErr = System.err;

    GameMessagePrinter messagePrinter;

    @BeforeEach
    void init() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        messagePrinter = new GameMessagePrinter();
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
            BallStrikeDto dto = new BallStrikeDto(0, 0);
            String expected = "낫싱\n";

            //when
            messagePrinter.printResultMessage(dto);

            //then
            assertThat(outContent.toString()).isEqualTo(expected);
        }

        @Test
        @DisplayName("1볼")
        void case2() {
            //given
            BallStrikeDto dto = new BallStrikeDto(1, 0);
            String expected = "1볼\n";

            //when
            messagePrinter.printResultMessage(dto);

            //then
            assertThat(outContent.toString()).isEqualTo(expected);
        }

        @Test
        @DisplayName("1스트라이크")
        void case3() {
            //given
            BallStrikeDto dto = new BallStrikeDto(0, 1);
            String expected = "1스트라이크\n";

            //when
            messagePrinter.printResultMessage(dto);

            //then
            assertThat(outContent.toString()).isEqualTo(expected);
        }

        @Test
        @DisplayName("1볼 1스트라이크")
        void case4() {
            //given
            BallStrikeDto dto = new BallStrikeDto(1, 1);
            String expected = "1볼 1스트라이크\n";

            //when
            messagePrinter.printResultMessage(dto);

            //then
            assertThat(outContent.toString()).isEqualTo(expected);
        }

        @Test
        @DisplayName("2볼 1스트라이크")
        void case5() {
            //given
            BallStrikeDto dto = new BallStrikeDto(2, 1);
            String expected = "2볼 1스트라이크\n";

            //when
            messagePrinter.printResultMessage(dto);

            //then
            assertThat(outContent.toString()).isEqualTo(expected);
        }

        @Test
        @DisplayName("3스트라이크")
        void case6() {
            //given
            BallStrikeDto dto = new BallStrikeDto(0, 3);
            String expected = "3스트라이크\n";

            //when
            messagePrinter.printResultMessage(dto);

            //then
            assertThat(outContent.toString()).isEqualTo(expected);
        }
    }


    @AfterEach
    void reset() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

}