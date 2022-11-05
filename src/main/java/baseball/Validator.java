package baseball;

public class Validator {

    public void validatePrediction(String predictedNumber) {
        if (!validateSize(predictedNumber))
            throw new IllegalArgumentException("잘못된 입력값입니다.");
        // Validate size
        // Validate digits
        // If false throw IllegalArgumentException
    }

    private boolean validateSize(String predictedNumber) {
        return predictedNumber.length() == 3;
    }
}
