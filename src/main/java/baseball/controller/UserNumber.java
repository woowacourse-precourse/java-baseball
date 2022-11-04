package baseball.controller;

import baseball.model.domain.NumberDto;

import static baseball.model.Utilization.convertStringToIntegerList;

public abstract class UserNumber {
    public static NumberDto generate(String userInput) {
        return new NumberDto(convertStringToIntegerList(userInput));
    }
}
