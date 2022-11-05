package baseball;

import java.util.List;

public class NumberComparison {

    public int checkStrike(List<Integer> correctAnswer, List<Integer> slicedNumber) {
        int count = 0;
        for (int seq = 0; seq < correctAnswer.size(); seq++) {
            if (correctAnswer.get(seq).equals(slicedNumber.get(seq))) {
                count++;
            }
        }
        return count;
    }

    public int checkBall(List<Integer> correctAnswer, List<Integer> slicedNumber) {
        int count = 0;
        for (int seq = 0; seq < correctAnswer.size(); seq++) {
            if (!(correctAnswer.get(seq).equals(slicedNumber.get(seq))) && correctAnswer.contains(slicedNumber.get(seq))) {
                count++;
            }
        }
        return count;
    }

}