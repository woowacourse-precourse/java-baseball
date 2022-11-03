package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

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
}
