package baseball.view;

import baseball.domain.Validator;

import java.io.*;

public interface UserInput {
    public String getInput() throws IOException;

    public int getEndGameInput() throws IOException;
}
