package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class MyApplicationTest {
    @Test
    void inputExceptionTestGameStart(){

        InputStream in = new ByteArrayInputStream("3".getBytes());
        System.setIn(in);
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        assertThrows(IllegalArgumentException.class, () -> Application.gameStart()) ;
    }
    @Test
    void inputExceptionTestGameRestart(){

        InputStream in = new ByteArrayInputStream("3".getBytes());
        System.setIn(in);
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        assertThrows(IllegalArgumentException.class, () -> Application.gameRestart()) ;
    }


}