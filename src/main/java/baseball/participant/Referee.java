package baseball.participant;

import baseball.result.Result;

public class Referee {

    public Result resultOfPrediction(String randomNumber, String pitchNumber) {
        return processResult(randomNumber, pitchNumber);
    }

    public Result processResult(String randomNumber, String pitchNumber) {
        Result result = new Result();
        compareRandomAndPitchNumber(result, randomNumber, pitchNumber);
        result.calculateType();
        return result;
    }

    private void compareRandomAndPitchNumber(Result result, String randomNumber, String pitchNumber) {
        for (int position = 0; position < 3; position++) {
            distinguishTypeOfDigit(result, randomNumber, pitchNumber, position);
        }
    }

    private void distinguishTypeOfDigit(Result result, String randomNumber, String pitchNumber, int position) {
        if (randomNumber.indexOf(pitchNumber.charAt(position)) == position) {
            result.increaseStrike();
        } else if (randomNumber.contains(String.valueOf(pitchNumber.charAt(position)))) {
            result.increaseBall();
        }
    }
}
