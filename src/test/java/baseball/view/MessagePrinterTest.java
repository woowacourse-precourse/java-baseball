package baseball.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MessagePrinterTest {

    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    final PrintStream standardOut = System.out;
    final MessagePrinter messagePrinter = new MessagePrinterImpl();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void printGameStart() {
        //given
        String expectOutput = "숫자 야구 게임을 시작합니다.";

        //when
        messagePrinter.printGameStart();

        //then
        assertEquals(expectOutput, outputStreamCaptor.toString().trim());
    }

    @Test
    void printInputNumber(){
        //given
        String expectOutput = "숫자를 입력해주세요 : ";

        //when
        messagePrinter.printReqGameNumbersInput();

        //then
        assertEquals(expectOutput,outputStreamCaptor.toString().replaceAll("(\r\n|\r|\n|\n\r)", ""));
    }

    @Test
    void printGameResult(){
        //given
        String expectOutput = "2볼 1스트라이크";

        //when
        messagePrinter.printGameResult(expectOutput);

        //then
        assertEquals(expectOutput,outputStreamCaptor.toString().replaceAll("(\r\n|\r|\n|\n\r)", ""));
    }

    @Test
    void printGameEnd(){
        //given
        String expectOutput = MessagesForPrint.GAME_END.getMessage();

        //when
        messagePrinter.printGameEnd();

        //then
        assertEquals(expectOutput,outputStreamCaptor.toString().replaceAll("(\r\n|\r|\n|\n\r)", ""));
    }
    @Test
    void printQuestionGameRestart(){
        //given
        String expectOutput = MessagesForPrint.RESTART_GAME.getMessage();

        //when
        messagePrinter.printQuestionGameRestart();

        //then
        assertEquals(expectOutput,outputStreamCaptor.toString().replaceAll("(\r\n|\r|\n|\n\r)", ""));
    }
}