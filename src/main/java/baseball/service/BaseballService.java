package baseball.service;

import baseball.domain.Baseball;

public class BaseballService {
    private final String BALL = "볼";
    private final String STRIKE = "스트라이크";
    private final String NOTHING = "낫싱";

    private final Baseball baseball;

    public BaseballService(Baseball baseball) {
        this.baseball = baseball;
    }

    public void start(String userInput) {
        baseball.compareResult(userInput);
    }

    public String getResult() {
        int[] result = baseball.getResult();
        int strikes = result[1];
        int balls = result[0];

        if (strikes + balls == 0) {
            return NOTHING;
        }

        StringBuilder answer = new StringBuilder();
        if (balls > 0)
            answer.append(balls + BALL + " ");
        if (strikes > 0)
            answer.append(strikes + STRIKE);

        return answer.toString();
    }


}
