package baseball;

import java.util.List;
import java.util.stream.IntStream;

public class Judge {
    private final List<Integer> ANSWER;

    public Judge(List<Integer> ANSWER) {
        this.ANSWER = ANSWER;
    }

    /**
     * @param guess user's guess
     * @return count list (ball, strike)
     */
    public List<Integer> judgeUserGuess(List<Integer> guess) {
        int strikeCount = countStrike(guess);
        int ballCount = ListUtil.countSameNumberInLists(guess, ANSWER) - strikeCount;

        return List.of(ballCount, strikeCount);
    }


    private int countStrike(List<Integer> guess) {
        return (int) IntStream.range(0, 3)
                .filter(index -> ANSWER.get(index) == guess.get(index))
                .count();
    }
}
