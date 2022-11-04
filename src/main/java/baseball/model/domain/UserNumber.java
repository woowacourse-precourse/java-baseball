package baseball.model.domain;

import static baseball.model.Utilization.convertStringToIntegerList;

public abstract class UserNumber {
    public static NumberDto generate(String userInput) {
        return new NumberDto(convertStringToIntegerList(userInput));
    }
}
