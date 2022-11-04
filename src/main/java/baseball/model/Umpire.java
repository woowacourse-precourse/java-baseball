package baseball.model;

import java.util.List;

public class Umpire {
    private final GameNumber computerGameNumber;
    private GameNumber playerGameNumber;

    public Umpire(GameNumber computerGameNumber, GameNumber playerGameNumber) {
        this.computerGameNumber = computerGameNumber;
        this.playerGameNumber = playerGameNumber;
    }

    public Umpire(GameNumber computerGameNumber) {
        this(computerGameNumber, null);
    }

    public void playerNewGameNumber(GameNumber playerGameNumber) {
        this.playerGameNumber = playerGameNumber;
    }

    public List<Integer> decision() {
        List<Integer> playerNumbers = playerGameNumber.getNumbers();
        List<Integer> computerNumbers = computerGameNumber.getNumbers();
        int strike = 0;
        int ball = 0;

        for (int gameCount = 0; gameCount < 3; gameCount++) {
            int playerPeek = playerNumbers.get(gameCount);
            int computerPeek = computerNumbers.get(gameCount);

            if (playerPeek == computerPeek) {
                strike++;
                continue;
            }
            if (computerNumbers.contains(playerPeek)) {
                ball++;
            }
        }

        return List.of(ball, strike);
    }

}
