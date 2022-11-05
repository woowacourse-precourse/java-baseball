package baseball.domain;

import baseball.exception.Validator;
import camp.nextstep.edu.missionutils.Console;

public class User {
    String numbers;
    Validator validator = new Validator();

    private void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public String getNumbers() {
        return numbers;
    }

    public void inputNumbers() {
        String value = Console.readLine();
        validator.validateInputNumbers(value);
        setNumbers(value);
    }

    public Character inputRetry() {
        String value = Console.readLine();
        validator.validateInputRetry(value);
        return value.charAt(0);
    }
}
