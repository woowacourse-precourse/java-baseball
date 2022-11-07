package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Computer {
    private static List<Integer> answerNumber;

    public List<Integer> getAnswerNumber() {
        return answerNumber;
    }

    public void generateNewRandomAnswer() {
        answerNumber = new ArrayList<>();
        while (answerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answerNumber.contains(randomNumber)) {
                answerNumber.add(randomNumber);
            }
        }
        if(!isValidNumber(answerNumber))
            throw new IllegalArgumentException();
    }

    public boolean isValidNumber(List<Integer> numbers) {
        for(Integer number: numbers) {
            int overlapCnt = Collections.frequency(numbers, number);
            if(overlapCnt > 1)
                return false;
            if(number < 1 || number > 9)
                return false;
        }
        return true;
    }

    public List<Integer> compareWithAnswer(List<Integer> numbers) {
        if(!isValidNumber(numbers))
            throw new IllegalArgumentException();

        List<Integer> result = new ArrayList<>();
        result.add(getStrikeCnt(numbers));
        result.add(getBallCnt(numbers));
        return result;
    }

    private Integer getStrikeCnt(List<Integer> numbers) {
        Integer cntStrike = 0;
        for(int i=0; i<3; i++) {
            if(numbers.get(i)==answerNumber.get(i)) {
                cntStrike++;
            }
        }
        return cntStrike;
    }

    private Integer getBallCnt(List<Integer> numbers) {
        Integer cntBall = 0;
        if(numbers.get(0)==answerNumber.get(1) || numbers.get(0)==answerNumber.get(2)) {
            cntBall++;
        }
        if(numbers.get(1)==answerNumber.get(0) || numbers.get(1)==answerNumber.get(2)) {
            cntBall++;
        }
        if(numbers.get(2)==answerNumber.get(0) || numbers.get(2)==answerNumber.get(1)) {
            cntBall++;
        }
        return cntBall;
    }
}
