package baseball.view;

import baseball.domain.Validator;

import java.io.*;

public class UserInput {
    private String getInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
//        int input = Integer.parseInt(br.readLine());
        Validator.validate(String.valueOf(input));
        return input;
    }
}
