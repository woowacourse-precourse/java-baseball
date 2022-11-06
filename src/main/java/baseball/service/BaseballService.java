package baseball.service;

import baseball.domain.Baseball;

public class BaseballService {
    private Baseball baseball;

    public void startGame() {
        this.baseball = new Baseball();
    }

    public void progress(String userInput) {
        baseball.comparingResult(userInput);
    }

    public String getResult() {
        int[] result = baseball.getResult();
        int strikes = result[1];
        int balls = result[0];

        if (strikes + balls == 0)
            return "낫싱";

        StringBuilder answerBuilder = new StringBuilder();
        if (balls > 0)
            answerBuilder.append(balls + "볼 ");
        if (strikes > 0)
            answerBuilder.append(strikes + "스트라이크");

        return answerBuilder.toString();
    }
}
