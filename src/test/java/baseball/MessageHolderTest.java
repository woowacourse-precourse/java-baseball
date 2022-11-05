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
    private MessageHolder holder;
    @BeforeAll
    void initAll() {
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
        //int output = holder.playerGameInputToInt("1234");

        assertThrows(IllegalArgumentException.class, ()->{
            holder.playerGameInputToInt("1234");
        });
        //assertEquals(output, 1234);
    }

    @Test
    void testPrintAskGameInput() {
        holder.printAskGameInput();
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        String result = "숫자를 입력해주세요 : ";
        assertEquals(result, out.toString());
    }

    @Test
    void testPrintAskRestart() {
        
    }

    @Test
    void testPrintBallAndStrike() {
        
    }

    @Test
    void testPrintStartMessage() {
        
    }

}
