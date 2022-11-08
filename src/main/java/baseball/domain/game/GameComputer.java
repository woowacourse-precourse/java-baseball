package baseball.domain.game;

import baseball.domain.number.GameNumbers;

public class GameComputer {

    private final GameNumbers answer;

    public GameComputer() {
        this.answer = new GameNumbers();
    }

    public GameResult calculateGameResult(GameNumbers playerAnswer) {
        long strike = answer.calculateStrike(playerAnswer);
        long ball = answer.calculateBall(playerAnswer);

        return new GameResult(strike, ball);
    }
}
