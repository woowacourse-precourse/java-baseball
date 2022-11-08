package baseball;

import java.util.List;
import java.util.stream.Collectors;

public class Digits {

    private final List<Digit> digitList;

    public Digits(List<Digit> inputDigitNumber) {
        this.digitList = inputDigitNumber;
    }

    public List<ScoreStatus> checkAllDigits(final Digits inputDigitList){
        return inputDigitList.digitList.stream()
                .map(this::checkOneDigits)
                .collect(Collectors.toList());
    }

    private ScoreStatus checkOneDigits(final Digit inputDigit) {
        return digitList.stream()
                .map(digit -> digit.isBallOrStrikeOrNothing(inputDigit))
                .filter(ballStatusResult -> ballStatusResult != ScoreStatus.NOTHING)
                .findAny()
                .orElse(ScoreStatus.NOTHING);
    }

    public List<Digit> getDigitList() {
        return digitList;
    }
}
