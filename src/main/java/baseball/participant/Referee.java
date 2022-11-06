package baseball.participant;

import baseball.result.Result;

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
}
