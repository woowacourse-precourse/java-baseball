package baseball.controller;

import baseball.model.domain.HintDto;
import baseball.model.domain.NumberDto;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

import static baseball.model.Constant.*;

public class GameController {
    private NumberDto computerNumber;
    private NumberDto userNumber;
    private final HintDto hint;

    public GameController() {
        userNumber = new NumberDto();
        hint = new HintDto();
    }

    public void generateComputerNumber() {
        computerNumber = ComputerNumber.generate();
    }

    public void setUserNumber(NumberDto userNumber) {
        this.userNumber = userNumber;
    }

    public GameController calculateHint() {
        List<Integer> result = Arrays.asList(0, 0);
        result.set(BALL_INDEX, countBall());
        result.set(STRIKE_INDEX, countStrike());
        hint.setHint(result);
        return this;
    }

    public String hintToString() {
        StringBuilder string = new StringBuilder();

        string.append(combine(hint.getHint().get(BALL_INDEX), BALL_MESSAGE));
        string.append(combine(hint.getHint().get(STRIKE_INDEX), STRIKE_MESSAGE));
        if (string.toString().isEmpty()) {
            return NOTHING_MESSAGE;
        }
        return string.toString();
    }

    private String combine(int value, String message) {
        StringBuilder string = new StringBuilder();

        if (value > 0) {
            string.append(value)
                    .append(message);
            if (message.equals(BALL_MESSAGE)) {
                string.append(BLANK);
            }
        }
        return string.toString();
    }

    public boolean isThreeStrike() {
        return hint
                .getHint()
                .equals(THREE_STRIKE);
    }

    public void refresh() {
        ComputerNumber.generate(computerNumber);
    }

    private int countBall() {
        int count = 0;

        if (!Objects.equals(userNumber.getNumber().get(0), computerNumber.getNumber().get(0))
                && (Objects.equals(userNumber.getNumber().get(0), computerNumber.getNumber().get(1))
                || Objects.equals(userNumber.getNumber().get(0), computerNumber.getNumber().get(2)))) {
            count++;
        }
        if (!Objects.equals(userNumber.getNumber().get(1), computerNumber.getNumber().get(1))
                && (Objects.equals(userNumber.getNumber().get(1), computerNumber.getNumber().get(2))
                || Objects.equals(userNumber.getNumber().get(1), computerNumber.getNumber().get(0)))) {
            count++;
        }
        if (!Objects.equals(userNumber.getNumber().get(2), computerNumber.getNumber().get(2))
                && (Objects.equals(userNumber.getNumber().get(2), computerNumber.getNumber().get(0))
                || Objects.equals(userNumber.getNumber().get(2), computerNumber.getNumber().get(1)))) {
            count++;
        }
        return count;
    }

    private int countStrike() {
//        return (int) userNumber
//                .getNumber()
//                .stream()
//                .filter(user -> computerNumber
//                        .getNumber()
//                        .stream()
//                        .allMatch(Predicate.isEqual(user)))
//                .count();

        int count = 0;

        if (Objects.equals(userNumber.getNumber().get(0), computerNumber.getNumber().get(0))) {
            count++;
        }
        if (Objects.equals(userNumber.getNumber().get(1), computerNumber.getNumber().get(1))) {
            count++;
        }
        if (Objects.equals(userNumber.getNumber().get(2), computerNumber.getNumber().get(2))) {
            count++;
        }
        return count;
    }
}
