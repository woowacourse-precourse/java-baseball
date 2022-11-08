package baseball;

import java.util.List;
import java.util.stream.IntStream;

public class Hint {
    private final int strike;
    private final int ball;

    public Hint(List<Integer> userNums, List<Integer> computerNums, int count) {
        strike = countStrike(userNums, computerNums, count);
        ball = countBall(userNums, computerNums, count);
        printHint(count);
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    private int countStrike(List<Integer> userNums, List<Integer> computerNums, int count) {
        return (int) IntStream.range(0, count)
                .filter(i -> userNums.get(i) == computerNums.get(i))
                .count();
    }

    private int countBall(List<Integer> userNums, List<Integer> computerNums, int count) {
        return (int) IntStream.range(0, count)
                .filter(i -> userNums.get(i) != computerNums.get(i)
                        && userNums.contains(computerNums.get(i)))
                .count();
    }

    private void printHint(int count) {
        if (strike == count) {
            System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return;
        }
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return;
        }
        System.out.printf("%d볼 %d스트라이크\n", ball, strike);
    }
}
