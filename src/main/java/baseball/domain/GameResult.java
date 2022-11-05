package baseball.domain;

import baseball.util.Message;
import baseball.util.Number;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameResult {
    int strike;
    int ball;

    private void setBall(int ball) {
        this.ball = ball;
    }
    private void setStrike(int strike) {
        this.strike = strike;
    }

    public boolean isThreeStrike() {
        return this.strike == Number.THREE;
    }

    public String toString() {
        if (Objects.equals(strike, Number.ZERO) && Objects.equals(ball, Number.ZERO)) {
            return Message.NOTHING;
        }

        StringBuilder result = new StringBuilder();
        if (Number.isPositive(ball)) {
            result.append(ball).append(Message.BALL).append(Message.SPACE);
        }
        if (Number.isPositive(strike)) {
            result.append(strike).append(Message.STRIKE);
        }
        return result.toString();
    }

    public void calculate(Computer computer, Player player) {
        List<Integer> strikeIndexes = countStrike(computer.getNumbers(), player.getNumbers());
        setBall(strikeIndexes.size());
        setStrike(countBallExceptStrike(computer.getNumbers(), player.getNumbers(), strikeIndexes));
    }

    List<Integer> countStrike(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        return IntStream.range(0, 3)
                .filter(i -> Objects.equals(computerNumbers.get(i), playerNumbers.get(i)))
                .boxed().collect(Collectors.toList());
    }

    int countBallExceptStrike(List<Integer> computer, List<Integer> player, List<Integer> strikeIndexes) {
        boolean[] computerUsed = new boolean[3];
        boolean[] playerUsed = new boolean[3];
        for (int idx : strikeIndexes) {
            computerUsed[idx] = true;
            playerUsed[idx] = true;
        }

        int ballCnt = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ballCnt += isBall(i, computer.get(i), computerUsed, j, player.get(j), playerUsed)
                        .compareTo(false);
            }
        }
        return ballCnt;
    }

    Boolean isBall(int computerIdx, int computerNumber, boolean[] computerUsed,
                   int playerIdx, int playerNumber, boolean[] playerUsed) {
        if (computerUsed[computerIdx] || playerUsed[playerIdx]) {
            return false;
        }
        if (computerNumber != playerNumber) {
            return false;
        }
        computerUsed[computerIdx] = playerUsed[playerIdx] = true;
        return true;
    }
}
