package baseball.input;

import static baseball.hint.Hint.BALL;
import static baseball.hint.Hint.NOTHING;
import static baseball.hint.Hint.STRIKE;

import baseball.hint.Hint;
import java.util.ArrayList;
import java.util.List;

public class InputControllerImp implements InputController {

    @Override
    public List<Integer> convertToIntegerList(String userInput) {
        List<Integer> user = new ArrayList<>();
        for (char digit : userInput.toCharArray()) {
            int number = Integer.parseInt(String.valueOf(digit));
            user.add(number);
        }
        return user;
    }

    @Override
    public String convertHintToString(Hint hint) {
        StringBuilder stringBuilder = new StringBuilder();
        int ball = hint.getBall();
        int strike = hint.getStrike();
        if (ball > 0) {
            stringBuilder.append(ball).append(BALL);
        }
        if (strike > 0) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(strike).append(STRIKE);
        }
        if (stringBuilder.length() == 0) {
            stringBuilder.append(NOTHING);
        }
        return stringBuilder.toString();
    }
}
