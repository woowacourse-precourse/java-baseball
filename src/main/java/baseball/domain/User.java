package baseball.domain;

import baseball.exception.Validator;
import camp.nextstep.edu.missionutils.Console;

import java.util.Scanner;

public class User {
    String numbers;
    Validator validator = new Validator();

    private void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public String getNumbers() {
        return numbers;
    }

    public void input() {
        String value = Console.readLine();
        validator.validateInput(value);
        setNumbers(value);
    }
}
