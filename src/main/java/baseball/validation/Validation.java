package baseball.validation;

import java.util.List;

import static baseball.number.util.GameNumberRange.*;
import static baseball.number.util.GamePhrase.*;

public class Validation {

    public void validatePlayerNumbers(List<Integer> playersNumberList) {


        validateListRange(playersNumberList);

        validateNumberRange(playersNumberList);

        validateDuplicateNumber(playersNumberList);

    }
    private void validateListRange(List<Integer> digitNumbers) {
        if(digitNumbers.size() != NUMBER_LENGTH.getNumber()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_LENGTH_THREE.getValue());
        }
    }

    private void validateNumberRange(List<Integer> digitNumbers) {
        int count = (int) digitNumbers.stream()
                .filter(number -> number >= RANGE_MIN.getNumber() && number <= RANGE_MAX.getNumber())
                .count();
        if(count != NUMBER_LENGTH.getNumber()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NUMBER_RANGE_ONE_TO_NINE.getValue());
        }
    }

    private void validateDuplicateNumber(List<Integer> digitNumbers) {
        int count = (int) digitNumbers.stream().distinct().count();

        if(count != NUMBER_LENGTH.getNumber()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_DUPLICATE.getValue());
        }
    }
}
