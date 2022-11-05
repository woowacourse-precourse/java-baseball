package baseball.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameResult {
    int strike;
    int ball;

    public int getStrike() {
        return this.strike;
    }

    public String toString() {
        if (strike == 3) {
            return "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        }
        if (strike == 0 && ball == 0) {
            return "낫싱";
        }

        StringBuilder result = new StringBuilder();
        if (0 < ball) {
            result.append(ball).append("볼 ");
        }
        if (0 < strike) {
            result.append(strike).append("스트라이크");
        }
        return result.toString();
    }

    public void calculate(Computer computer, Player player) {
        List<Integer> strikeIndexes = countStrike(computer.getNumbers(), player.getNumbers());
        this.strike = strikeIndexes.size();
        this.ball = countBallExceptStrike(computer.getNumbers(), player.getNumbers(), strikeIndexes);
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
