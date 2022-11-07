package baseball.factory;

import java.io.*;

public class InputFactory {

    public static void inputNumber(String number) {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(number.getBytes());
        System.setIn(in);
    }
}
