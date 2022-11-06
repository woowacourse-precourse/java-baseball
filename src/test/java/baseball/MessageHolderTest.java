package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class MessageHolderTest {
    private static MessageHolder holder;

    @BeforeAll
    static void initAll() {
        holder = new MessageHolder();
    }

    @Test
    void testGetGameInput() {
        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("245".getBytes());
        System.setIn(in);

        String output = holder.GetGameInput();
        System.setIn(sysInBackup);

        assertEquals(output, "245");
    }

    @Test
    void testGetPlayerRestartInput() {
        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);

        int output = holder.getPlayerRestartInput();
        System.setIn(sysInBackup);

        assertEquals(output, 1);
    }

    @Test
    void testPlayerGameInputToInt() {
        assertThrows(IllegalArgumentException.class, () ->
            {
                holder.playerGameInputToInt("1234");
            });
    }

    @Test
    void testPrintAskGameInput() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        holder.printAskGameInput();

        String result = "숫자를 입력해주세요 : ";
        assertEquals(result, out.toString());
    }

    @Test
    void testPrintAskRestart() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        holder.printAskRestart();

        String result = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
        assertEquals(result, out.toString().trim());
    }

    @Test
    void testPrintBallAndStrike() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        holder.printBallAndStrike(1, 1);

        String result = "1볼 1스트라이크";
        assertEquals(result, out.toString().trim());
    }

    @Test
    void testPrintStartMessage() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        holder.printStartMessage();

        String result = "숫자 야구 게임을 시작합니다.";
        assertEquals(result, out.toString().trim());
    }

}
