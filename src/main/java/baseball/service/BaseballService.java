package baseball.service;

import baseball.model.Score;
import baseball.util.Calculator;
import baseball.validator.NumberValidator;

public class BaseballService {

    public Score compareNumber(String baseballNumber, String userNumber) {
        NumberValidator.validate(userNumber);
        return Calculator.score(baseballNumber, userNumber);
    }

}
