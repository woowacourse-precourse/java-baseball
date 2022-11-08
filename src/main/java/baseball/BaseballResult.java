package baseball;

public class BaseballResult {
    private BaseballResult() {

    }

    public static BaseballScore getBaseballScore(BaseballNumber computerNumbers, BaseballNumber userNumbers) {
        int strikes = 0;
        int balls = 0;

        for (int index = 0; index < BaseballNumber.NUMBER_COUNT; index++) {
            int number = userNumbers.get(index);

            if (isStrike(computerNumbers, index, number)) {
                strikes += 1;
                continue;
            }

            if (isBall(computerNumbers, number)) {
                balls += 1;
            }
        }
        return new BaseballScore(strikes, balls);
    }

    private static boolean isStrike(BaseballNumber computerNumbers, int index, int number) {
        return computerNumbers.isNumberInIndexEqualTo(index, number);
    }

    private static boolean isBall(BaseballNumber computerNumbers, int number) {
        return computerNumbers.contains(number);
    }
}
