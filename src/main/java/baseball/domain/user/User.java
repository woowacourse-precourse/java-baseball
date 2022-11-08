package baseball.domain.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class User {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public String answer() throws IOException {
        return getReader().readLine();
    }

    BufferedReader getReader(){
        return reader;
    }
}
