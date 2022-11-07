package baseball.domain;

import java.util.stream.IntStream;

public class Referee {

    public static final int INDEX_NOT_FOUND = -1;

    public GameResult judge(String answer, String userNumber) {
        return new GameResult(getStrikeCount(answer, userNumber), getBallCount(answer, userNumber));
    }

    private int getStrikeCount(String answer, String userNumber) {
        return (int) IntStream.range(0, answer.length())
                .filter(index -> isStrike(answer, userNumber, index))
                .count();
    }

    private int getBallCount(String answer, String userNumber) {
        return (int) IntStream.range(0, userNumber.length())
                .filter(index -> isBall(answer.indexOf(userNumber.charAt(index)), index))
                .count();
    }

    private boolean isStrike(String answer, String userNumber, int index) {
        return answer.charAt(index) == userNumber.charAt(index);
    }

    private boolean isBall(int findIndexInAnswer, int userNumberCharIndex) {
        return (findIndexInAnswer != INDEX_NOT_FOUND && findIndexInAnswer != userNumberCharIndex);
    }
}
