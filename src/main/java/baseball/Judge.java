package baseball;

import java.util.List;

public class Judge {
    private final List<Integer> ANSWER;

    public Judge(List<Integer> ANSWER) {
        this.ANSWER = ANSWER;
    }

    public List<Integer> judgeUserGuess(List<Integer> guess) {
        int strikeCount = ListUtil.countSameNumberInSameLocationInLists(guess, ANSWER);
        int ballCount = ListUtil.countSameNumberInLists(guess, ANSWER) - strikeCount;

        return List.of(ballCount, strikeCount);
    }
}
