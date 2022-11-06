package baseball.result;

public class Result {
    private static final Integer NUMBER_LENGTH = 3;
    private Integer strikeCount;
    private Integer ballCount;

    public Result(Integer strikeCount, Integer ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public void countStrike(String computerNumber, String userNumber) {
        Integer count = 0;
        for (int index = 0; index < NUMBER_LENGTH; index++) {
            if (computerNumber.charAt(index) == userNumber.charAt(index)) {
                count++;
            }
        }

        strikeCount = count;
    }

    public void countBall(String computerNumber, String userNumber) {
        Integer count = 0;
        for (char number: userNumber.toCharArray()) {
            if (computerNumber.contains(String.valueOf(number))) {
                count++;
            }
        }

        ballCount = count - strikeCount;
    }


    public Integer getStrikeCount() {
        return strikeCount;
    }

    public Integer getBallCount() {
        return ballCount;
    }

    public boolean isNothing() {
        if (strikeCount == 0 && ballCount == 0) {
            return true;
        }

        return false;
    }
}
