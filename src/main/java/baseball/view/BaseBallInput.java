package baseball.view;

import baseball.domain.Validator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaseBallInput implements UserInput{
    public String getInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Validator.validate(String.valueOf(input));
        return input;
    }
}
