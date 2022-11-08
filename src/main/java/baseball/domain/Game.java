package baseball.domain;

public class Game {
    private int strike;
    private int ball;

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void compare(String userInput, String computerProducedRandomNumber) {
        strike = 0;
        ball = 0;

        for (String s : userInput.split("")) {
            if (computerProducedRandomNumber.contains(s)) {
                if (userInput.indexOf(s) == computerProducedRandomNumber.indexOf(s)) {
                    this.strike += 1;
                } else {
                    this.ball += 1;
                }
            }
        }
    }
}
