package baseball.service;

import baseball.model.BaseBall;
import baseball.model.Score;
import baseball.model.User;
import baseball.util.InputValidator;

import java.util.List;

public class BaseBallService {

    private static BaseBall baseBall;
    private static User user;

    public void init() {
        baseBall = new BaseBall();
        user = new User();
    }

    public Score compareAnswer(String input) {
        List<Integer> numbers = user.toList(input);
        return baseBall.compareAnswer(numbers);
    }

    public void validateQuitOrContinueCommand(String input) {
        InputValidator.validateCommand(input);
    }
}
