package baseball;

import java.util.List;

public class NumberComparison {

    public int checkStrike(List<Integer> correctAnswer) {
        int count = 0;
        UserInput input = new UserInput();
        List<Integer> slicedInput = input.input();
        for (int seq = 0; seq < correctAnswer.size(); seq++) {
            if (correctAnswer.get(seq).equals(slicedInput.get(seq))) {
                count++;
            }
        }
        return count;
    }

    public int checkBall(List<Integer> correctAnswer) {
        int count = 0;
        UserInput input = new UserInput();
        List<Integer> slicedInput = input.input();
        for (int seq = 0; seq < correctAnswer.size(); seq++) {
            if (!(correctAnswer.get(seq).equals(slicedInput.get(seq))) && correctAnswer.contains(slicedInput.get(seq))) {
                count++;
            }
        }
        return count;
    }

}