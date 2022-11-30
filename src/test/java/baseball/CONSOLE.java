package baseball;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public enum CONSOLE {

    CONSOLE;


    public static InputStream setConsole(String readLine) {

        return new ByteArrayInputStream(readLine.getBytes());

    }
}
