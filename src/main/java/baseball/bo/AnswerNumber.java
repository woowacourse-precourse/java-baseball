package baseball.bo;

import baseball.Interfaces.RandomNumber;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class AnswerNumber implements RandomNumber {
    private final List<Integer> answerNumbers;

    public AnswerNumber() {
        this.answerNumbers = getUniqueThreeNumbers();
    }

    @Override
    public List<Integer> getNumbers() {
        return answerNumbers;
    }

    private List<Integer> getUniqueThreeNumbers() {
        List<Integer> numberList = new ArrayList<>();

        while (numberList.size() != MAX_NUMBER_OF_DIGIT) {
            int tempNum = Randoms.pickNumberInRange(MIN_NUMBER_OF_RANGE,MAX_NUMBER_OF_RANGE);
            if (!numberList.contains(tempNum)) {
                numberList.add(tempNum);
            }
        }
        return numberList;
    }
}
