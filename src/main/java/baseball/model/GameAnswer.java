package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameAnswer {
    private List<Integer> answer;

    public GameAnswer() {
    }

    public List<Integer> getNumber() {
        return answer;
    }

    public void setNumber() {
        answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
    }
}
