package baseball.domain.game;

import baseball.domain.computer.Computer;
import baseball.domain.player.Player;

import java.util.List;
import java.util.stream.IntStream;

import static baseball.utils.Constants.*;

public class GameHint {
    private int strikeScore;
    private int ballScore;
    private Computer computer;
    private Player player;

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
        List<Integer> computerNums = computer.getRandomNumbers();
        List<Integer> playerNums = player.getInputNumbers();

        strikeScore = calculateStrikeScore(computerNums, playerNums);
        ballScore = calculateBallScore(computerNums, playerNums);
    }

    private int calculateStrikeScore(List<Integer> computerNums, List<Integer> playerNums) {
        return (int) IntStream
                .range(0, BASEBALL_DIGIT_LENGTH)
                .filter(i -> isStrike(computerNums.get(i), (playerNums.get(i))))
                .count();
    }

    private int calculateBallScore(List<Integer> computerNums, List<Integer> playerNums) {
        return (int) IntStream
                .range(0, BASEBALL_DIGIT_LENGTH)
                .filter(i -> !isStrike(computerNums.get(i), (playerNums.get(i))))
                .filter(i -> isBall(computerNums, playerNums.get(i)))
                .count();
    }

    private boolean isStrike(Integer computerNum, Integer playerNum) {
        return computerNum.equals(playerNum);
    }

    private boolean isBall(List<Integer> computerNum, Integer playerNum) {
        return computerNum.contains(playerNum);
    }

    public int getStrikeScore() {
        return strikeScore;
    }

    public int getBallScore() {
        return ballScore;
    }
}
