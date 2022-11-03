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

    private int STRIKE_COUNT = 0;
    private int BALL_COUNT = 0;


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

    private String getResultScoreByFormat() {
        return getBallNumber() + getStrikeNumber();
    }

    private String getStrikeNumber() {
        STRIKE_COUNT = 0;

        for (int index = 0; index < userInput.length(); index++) {
            if (isStrike(index)) {
                STRIKE_COUNT++;
            }
        }
        return STRIKE.of(STRIKE_COUNT);
    }

    private boolean isStrike(int index) {
        return answerNumber.charAt(index) == userInput.charAt(index);
    }

    private String getBallNumber() {
        BALL_COUNT = 0;

        for (int index = 0; index < userInput.length(); index++) {
            if (isBall(index)) {
                BALL_COUNT++;
            }
        }
        return BALL.of(BALL_COUNT - STRIKE_COUNT);
    }

    private boolean isBall(int index) {
        return !isStrike(index) && answerNumberList.contains(userInput.charAt(index));
    }

    private boolean isNothing() {
        return convertStringToCharList(userInput).stream()
                .noneMatch(answerNumberList::contains);
    }
}
