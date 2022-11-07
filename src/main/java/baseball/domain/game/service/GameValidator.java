package baseball.domain.game.service;

public interface GameValidator {

    void validateNumber(String number);

    void validateContinueOrStop(String response);
}
