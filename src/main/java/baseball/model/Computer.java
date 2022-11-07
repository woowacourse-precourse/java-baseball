package baseball.model;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int NUMBER_LENGTH = 3;

    private List<Integer> answer;

    public List<Integer> setRandomNumber() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        this.answer = answer;
        return answer;
    }

    public List<Integer> getAnswer() {
        return answer;
    }
}