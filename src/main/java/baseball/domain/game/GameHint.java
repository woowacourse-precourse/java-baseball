package baseball.domain.game;

import baseball.domain.computer.Computer;
import baseball.domain.player.Player;

import java.util.List;

import static baseball.utils.Constants.*;

public class GameHint {
    private Computer computer;
    private Player player;

    private int strikeScore;
    private int ballScore;

    private GameHint(Computer computer, Player player) {
        this.computer = computer;
        this.player = player;
        strikeScore = 0;
        ballScore = 0;
        compareNumbers();
    }

    public static GameHint compare(Computer computer, Player player) {
        return new GameHint(computer, player);
    }

    private void compareNumbers() {
        List<Integer> computerNum = computer.getRandomNumbers();
        List<Integer> playerNum = player.getInputNumbers();

        for (int i = 0; i < BASEBALL_DIGIT_LENGTH; i++) {
            if (computerNum.get(i).equals(playerNum.get(i))) {
                strikeScore += 1;
                continue;
            }

            if (computerNum.contains(playerNum.get(i))) {
                ballScore += 1;
            }
        }
    }

    public int getStrikeScore() {
        return strikeScore;
    }

    public int getBallScore() {
        return ballScore;
    }
}
