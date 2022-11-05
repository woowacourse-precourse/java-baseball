package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

import static baseball.ResultMessage.*;

public class BullsAndCows {
    private final String answerNumber;
    private final List<Character> answerNumberList;
    public boolean remainStatus;

    private String userInput;

    private int strikeCount = 0;
    private int ballCount = 0;
    private static final int STRIKE_COUNT_FOR_END = 3;


    BullsAndCows() {
        int randomNumber = Randoms.pickNumberInRange(100, 999);
        this.answerNumber = String.valueOf(randomNumber);
        answerNumberList = convertStringToCharList(answerNumber);
    }

    private List<Character> convertStringToCharList(String string) {
        return string
                .chars()
                .mapToObj(e -> (char) e)
                .collect(Collectors.toList());
    }

    public String getResultOfGuessNumber(String userInput) {
        this.userInput = userInput;

        if (isNothing()) {
            return NOTHING.getMessage();
        }

        return getResultScoreByFormat().trim();
    }

    private String getResultScoreByFormat() {
        return getBallNumber() + " " + getStrikeNumber();
    }

    private String getStrikeNumber() {
        strikeCount = 0;

        for (int index = 0; index < userInput.length(); index++) {
            if (isStrike(index)) {
                strikeCount++;
            }
        }
        return STRIKE.of(strikeCount);
    }

    private boolean isStrike(int index) {
        return answerNumber.charAt(index) == userInput.charAt(index);
    }

    private String getBallNumber() {
        ballCount = 0;

        for (int index = 0; index < userInput.length(); index++) {
            if (isBall(index)) {
                ballCount++;
            }
        }
        return BALL.of(ballCount - strikeCount);
    }

    private boolean isBall(int index) {
        return !isStrike(index) && answerNumberList.contains(userInput.charAt(index));
    }

    private boolean isNothing() {
        return convertStringToCharList(userInput).stream()
                .noneMatch(answerNumberList::contains);
    }

    public boolean isEnd() {
        return strikeCount == STRIKE_COUNT_FOR_END;
    }
}
