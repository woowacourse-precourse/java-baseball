package baseball;

public class ResultProcessor {

    public Result processResult(String randomNumber, String predictedNumber) {
        Result result = new Result();
        // Compare result and prediction number
        // Calculate result type
        return result;
    }

    private void compareRandomAndPredictedNumber(Result result, String randomNumber, String predictedNumber) {
        for (int i = 0; i < 3; i++) {
            distinguishTypeOfDigit(result, randomNumber, predictedNumber, i);
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
