package baseball.domain;

public class Referee {

    public static final int INDEX_NOT_FOUND = -1;

    public GameResult judge(String answer, String userNumber) {
        return new GameResult(getStrikeCount(answer, userNumber), getBallCount(answer, userNumber));
    }

    private int getStrikeCount(String answer, String userNumber) {
        int strikeCount = 0;

        for (int index = 0; index < answer.length(); index++) {
            if (isStrike(answer, userNumber, index)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private int getBallCount(String answer, String userNumber) {
        int ballCount = 0;

        for (int index = 0; index < userNumber.length(); index++) {
            if (isBall(answer.indexOf(userNumber.charAt(index)), index)) {
                ballCount++;
            }
        }
        return ballCount;
    }

    private boolean isStrike(String answer, String userNumber, int index) {
        return answer.charAt(index) == userNumber.charAt(index);
    }

    private Boolean isBall(int findIndexInAnswer, int userNumberCharIndex) {
        return (findIndexInAnswer != INDEX_NOT_FOUND && findIndexInAnswer != userNumberCharIndex);
    }
}
