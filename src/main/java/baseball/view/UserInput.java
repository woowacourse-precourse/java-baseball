package baseball.view;

import baseball.domain.Validator;

import java.io.*;

public class UserInput {
    private int getInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        Validator.validate(input);
        return input;
    }
}
