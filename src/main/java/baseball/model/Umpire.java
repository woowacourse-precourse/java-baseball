package baseball.model;

import java.util.List;

public class Umpire {
    private final GameNumber answer;

    public Umpire(GameNumber answer) {
        this.answer = answer;
    }

    public GameResult decision(GameNumber playerGameNumber) {
        List<Integer> answerNumbers = answer.getNumbers();
        List<Integer> playerNumbers = playerGameNumber.getNumbers();
        int strike = 0;
        int ball = 0;

        for (int gameCount = 0; gameCount < 3; gameCount++) {
            int playerPeek = playerNumbers.get(gameCount);
            int computerPeek = answerNumbers.get(gameCount);

            if (playerPeek == computerPeek) {
                strike++;
                continue;
            }
            if (answerNumbers.contains(playerPeek)) {
                ball++;
            }
        }

        return new GameResult(ball, strike);
    }

}
