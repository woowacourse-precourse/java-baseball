package baseball.service;

import baseball.model.Score;
import baseball.util.Calculator;
import baseball.validator.NumberValidator;

public class BaseballService {
    private static final String RESTART = "1";

    public Score compareNumber(String baseballNumber, String userNumber) {
        NumberValidator.validate(userNumber);
        return Calculator.count(baseballNumber, userNumber);
    }

    public boolean restartCheck(String userChoice) {
        NumberValidator.number(userChoice);
        return userChoice.equals(RESTART);
    }
}
