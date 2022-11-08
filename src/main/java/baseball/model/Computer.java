package baseball.model;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private static final int MIN = 1;
    private static final int MAX = 9;
    private static final int NUMBER_LENGTH = 3;
    private List<Integer> answer;

    public Computer() {
        initAnswer();
    }

    public void initAnswer() {
        answer = new ArrayList<Integer>();
    }

    public void makeAnswer() {
        while (answer.size() != NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN, MAX);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
    }

    public List<Integer> getAnswer() {
        return answer;
    }
}
