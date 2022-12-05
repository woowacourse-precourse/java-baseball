package baseball;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public enum CONSOLE {

    CONSOLE;

    public static void setUp(String readLine) {

        InputStream console = new ByteArrayInputStream(readLine.getBytes());
        System.setIn(console);

    }


}
