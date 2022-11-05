package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {

    private final List<Integer> answer = new ArrayList<>();

    public List<Integer> getAnswer() {
        return this.answer;
    }

    public void setAnswer() {
        this.answer.clear();
        while (this.answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!this.answer.contains(randomNumber)) {
                this.answer.add(randomNumber);
            }
        }
    }
}
