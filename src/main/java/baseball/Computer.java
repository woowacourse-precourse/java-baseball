package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import constantfield.Detail;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private final List<Integer> answer;

    public Computer() {
        answer = new ArrayList<>();
    }

    public void makeAnswerNum() {
        while (answer.size() < Detail.LENGTH) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNum)) {
                answer.add(randomNum);
            }
        }
    }

    public List<Integer> getAnswer() {
        return answer;
    }
}
