package baseball;

import java.util.List;

public class ComputerNumbers {
    private List<String> randomNumbers;

    public ComputerNumbers(List<String> randomNumbers) {
        validate(randomNumbers);
        this.randomNumbers = randomNumbers;
    }

    public boolean hasSameNumber(String playerNumber) {
        return randomNumbers.contains(playerNumber);
    }

    public boolean isStrike(String playerNumber, int numberIndex) {
        return randomNumbers.get(numberIndex).equals(playerNumber);
    }

    private void validate(List<String> randomNumbers) {
        validateNull(randomNumbers);
        validateZeroInclude(randomNumbers);
        validateSize(randomNumbers);
        validateNumericOnly(randomNumbers);
        validateRange(randomNumbers);
    }

    private void validateNull(List<String> randomNumbers) {
    }

    private void validateZeroInclude(List<String> randomNumbers) {
    }

    private void validateSize(List<String> randomNumbers) {
    }

    private void validateNumericOnly(List<String> randomNumbers) {
    }

    private void validateRange(List<String> randomNumbers) {
    }
}
