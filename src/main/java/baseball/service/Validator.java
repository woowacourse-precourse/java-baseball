package baseball.service;

import java.util.Arrays;
import java.util.HashSet;

public class Validator {

    public void validatePrediction(String pitchNumber) {
        if (!validateSize(pitchNumber) || !validateDigits(pitchNumber))
            throw new IllegalArgumentException("잘못된 입력값입니다.");
    }

    private boolean validateSize(String pitchNumber) {
        return pitchNumber.length() == 3;
    }

    private boolean validateDigits(String pitchNumber) {
        return areAllDecimalDigits(pitchNumber) && areAllDifferentDigit(pitchNumber);
    }

    private boolean areAllDecimalDigits(String pitchNumber) {
        return pitchNumber.matches("[1-9]+");
    }

    private boolean areAllDifferentDigit(String pitchNumber) {
        return new HashSet<>(Arrays.asList(pitchNumber.split(""))).size() == 3;
    }

    public void validateReplaySelection(String replay) {
        if (!replay.equals("1") && !replay.equals("2"))
            throw new IllegalArgumentException("잘못된 입력값입니다.");
    }
}
