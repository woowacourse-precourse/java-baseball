package baseball.util;

import baseball.model.Score;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Calculator {

    public static Score score(String baseballNumber, String userNumber) {
        String[] baseBallNumberSplit = baseballNumber.split("");
        String[] userNumberSplit = userNumber.split("");

        int strikeCount = getStrikeCount(baseBallNumberSplit, userNumberSplit);
        int ballCount = getBallCount(baseballNumber, userNumberSplit, strikeCount);
        return new Score(ballCount, strikeCount);
    }

    private static int getBallCount(String baseballNumber, String[] userNumberSplit, int strikeCount) {
        return (int) Arrays.stream(userNumberSplit)
                .filter(baseballNumber::contains)
                .count() - strikeCount;
    }

    private static int getStrikeCount(String[] baseBallNumberSplit, String[] userNumberSplit) {
        return (int) IntStream.range(0, baseBallNumberSplit.length)
                .filter(i -> baseBallNumberSplit[i].equals(userNumberSplit[i]))
                .count();
    }

}
