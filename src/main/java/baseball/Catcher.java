package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Catcher {

    private List<Integer> answer;

    public void initRandomNumbers() {
        answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
    }

    public List<Integer> getAnswer() {
        return this.answer;
    }
}
