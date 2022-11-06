package baseball.participant;

import baseball.result.Result;

import java.util.Arrays;
import java.util.HashSet;

public class Referee {

    public Result resultOfPrediction(String hitNumber, String pitchNumber) {
        return processResult(hitNumber, pitchNumber);
    }

    public Result processResult(String hitNumber, String pitchNumber) {
        Result result = new Result();
        compareHitAndPitchNumber(result, hitNumber, pitchNumber);
        result.calculateType();
        return result;
    }

    private void compareHitAndPitchNumber(Result result, String hitNumber, String pitchNumber) {
        for (int position = 0; position < 3; position++) {
            distinguishTypeOfDigit(result, hitNumber, pitchNumber, position);
        }
    }

    private void distinguishTypeOfDigit(Result result, String hitNumber, String pitchNumber, int position) {
        if (hitNumber.indexOf(pitchNumber.charAt(position)) == position) {
            result.increaseStrike();
        } else if (hitNumber.contains(String.valueOf(pitchNumber.charAt(position)))) {
            result.increaseBall();
        }
    }

    public void pitchIsBalk(String pitchNumber) {
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
