package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameAnswer {
    private List<Integer> answer;

    public GameAnswer() {
        setNumber();
    }

    public List<Integer> getNumber() {
        return answer;
    }

    public void setNumber() {
        this.answer = new ArrayList<>();
        while (this.answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!this.answer.contains(randomNumber)) {
                this.answer.add(randomNumber);
            }
        }
    }
}
