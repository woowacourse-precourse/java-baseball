package baseball;

import java.util.List;

public class Game {
    private List<Integer> computerNumber;

    private void start(Player computer) {
        Print.startGame();
        this.computerNumber = computer.getComputerRandomNumber();
    }

    private String playGame(Player player) {
        List<Integer> score;
        List<Integer> playerNumber;

        Print.enterNumber();
        playerNumber = player.enterNumber();
        score = GameScore.getGameScore(playerNumber, this.computerNumber);

        return GameScore.getGameResult(score.get(0), score.get(1));
    }
}
