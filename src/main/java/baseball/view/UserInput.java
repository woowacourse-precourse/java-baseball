package baseball.view;

import java.io.*;

public interface UserInput {
    public String getInput() throws IOException;

    public int getEndGameInput() throws IOException;
}
