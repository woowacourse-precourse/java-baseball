package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Test;

public class MessageHolderTest {
    public MessageHolder holder;

    @Test
    void testGetGameInput() {
        holder = new MessageHolder();
        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("245".getBytes());
        System.setIn(in);

        String output = holder.GetGameInput();
        System.setIn(sysInBackup);

        assertEquals(output, "245");
    }

    @Test
    void testGetPlayerRestartInput() {
        holder = new MessageHolder();
        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);

        int output = holder.getPlayerRestartInput();
        System.setIn(sysInBackup);

        assertEquals(output, 1);
    }

    @Test
    void testPlayerGameInputToInt() {
        
    }

    @Test
    void testPrintAskGameInput() {
        
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
