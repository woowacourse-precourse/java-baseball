package baseball;

public class BaseballResult {
    public BaseballScore getBaseballScore(BaseballNumber computerNumbers, BaseballNumber userNumbers) {
        int strikes = 0;
        int balls = 0;

        for (int index = 0; index < BaseballNumber.NUMBER_COUNT; index++) {
            int number = userNumbers.get(index);

            if (is_strike(computerNumbers, index, number)) {
                strikes += 1;
                continue;
            }

            if (is_ball(computerNumbers, number)) {
                balls += 1;
            }
        }
        return new BaseballScore(strikes, balls);
    }

    private boolean is_strike(BaseballNumber computerNumbers, int index, int number) {
        return computerNumbers.is_number_in_index_equal_to(index, number);
    }

    private boolean is_ball(BaseballNumber computerNumbers, int number) {
        return computerNumbers.contains(number);
    }
}
