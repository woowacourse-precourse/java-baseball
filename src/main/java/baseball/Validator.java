package baseball;

import java.util.Arrays;
import java.util.HashSet;

public class Validator {

    public void validatePrediction(String predictedNumber) {
        if (!validateSize(predictedNumber) || !validateDigits(predictedNumber))
            throw new IllegalArgumentException("잘못된 입력값입니다.");
    }

    private boolean validateSize(String predictedNumber) {
        return predictedNumber.length() == 3;
    }

    private boolean validateDigits(String predictedNumber) {
        return areAllDecimalDigits(predictedNumber) && areAllDifferentDigit(predictedNumber);
    }

    private boolean areAllDecimalDigits(String predictedNumber) {
        return predictedNumber.matches("[1-9]+");
    }

    private boolean areAllDifferentDigit(String predictedNumber) {
        return new HashSet<>(Arrays.asList(predictedNumber.split(""))).size() == 3;
    }
}
