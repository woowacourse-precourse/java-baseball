package baseball.participant;

import baseball.result.Result;

public class Referee {

    public Result resultOfPrediction(String randomNumber, String predictedNumber) {
        return processResult(randomNumber, predictedNumber);
    }

    public Result processResult(String randomNumber, String predictedNumber) {
        Result result = new Result();
        compareRandomAndPredictedNumber(result, randomNumber, predictedNumber);
        result.calculateType();
        return result;
    }

    private void compareRandomAndPredictedNumber(Result result, String randomNumber, String predictedNumber) {
        for (int position = 0; position < 3; position++) {
            distinguishTypeOfDigit(result, randomNumber, predictedNumber, position);
        }
    }

    private void distinguishTypeOfDigit(Result result, String randomNumber, String predictedNumber, int position) {
        if (randomNumber.indexOf(predictedNumber.charAt(position)) == position) {
            result.increaseStrike();
        } else if (randomNumber.contains(String.valueOf(predictedNumber.charAt(position)))) {
            result.increaseBall();
        }
    }
}
