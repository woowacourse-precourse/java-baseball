package baseball.mvc.view;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public abstract class OutputSettings {

    protected static ByteArrayOutputStream testOut = new ByteArrayOutputStream();
    protected static PrintStream standardOut;

    @BeforeEach
    void initOutputStreamSettings() {
        testOut.reset();
        standardOut = System.out;
        System.setOut(new PrintStream(testOut));
    }

    @AfterEach
    void printOutputStream() {
        System.setOut(standardOut);
        System.out.println(testOut.toString().trim());
    }
}
