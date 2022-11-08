package baseball.input;

import static baseball.constant.Rules.END_INCLUSIVE;
import static baseball.constant.Rules.NUMBER_LENGTH;
import static baseball.constant.Rules.START_INCLUSIVE;

import java.util.ArrayList;
import java.util.List;

public class InputControllerImp implements InputController {

    @Override
    public boolean checkValidAnswer(String userInput) {
        return checkFormat(userInput) && checkDistinct(userInput);
    }

    @Override
    public List<Integer> convertToIntegerList(String userInput) {
        List<Integer> user = new ArrayList<>();
        for (char digit : userInput.toCharArray()) {
            int number = Integer.parseInt(String.valueOf(digit));
            user.add(number);
        }
        return user;
    }

    private boolean checkFormat(String userInput) {
        String regex = String.format(
                "[%d-%d]{%d}$",
                START_INCLUSIVE,
                END_INCLUSIVE,
                NUMBER_LENGTH
        );
        return userInput.matches(regex);
    }

    private boolean checkDistinct(String userInput) {
        return userInput.chars().distinct().count() == NUMBER_LENGTH;
    }
}
