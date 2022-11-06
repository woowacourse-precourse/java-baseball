package baseball.player;

import baseball.utils.validator.InputValidator;

public class PlayerInputValidatorImple implements PlayerInputValidator {
    @Override
    public void validatePlayerInput(String input){
        InputValidator.validateEachDigitDifferent(input);
        InputValidator.validateEachDigitBetween1And9(input);
        InputValidator.validateIs3DigitNumber(input);
    }
}
