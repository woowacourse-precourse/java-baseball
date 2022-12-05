package baseball;

import java.util.List;

public class Computer {
    private final List randomNumberList;
    Result result;

    public Result getResult() {
        return result;
    }

    public boolean compareAndResult(List userNumberList) {
        boolean retry = true;
        CountScore countScore = new CountScore();
        countScore.compare(randomNumberList, userNumberList);
        if (countScore.getStrike() == 3) {
            retry = false;
        }
        result = new Result();
        result.convertToString(countScore.getBall(), countScore.getStrike());
        return retry;
    }

    public Computer(List randomNumber) {
        this.randomNumberList = randomNumber;
    }

    public List getRandomNumberList() {
        return randomNumberList;
    }
}
