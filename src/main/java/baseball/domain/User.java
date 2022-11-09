package baseball.domain;

import baseball.view.InputView;
import java.util.ArrayList;
import java.util.List;

public class User {
    public static List<Integer> getNumbers() {
        List<Integer> userNumbers = new ArrayList<>();
        String input = InputView.askNumberMessage();

        if (Referee.validateUserInput(input, userNumbers)){
            for (char c: input.toCharArray()){
                userNumbers.add(Character.getNumericValue(c));
            }
        }

        return userNumbers;
    }

}
