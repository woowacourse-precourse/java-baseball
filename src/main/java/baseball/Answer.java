package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Answer {
    private List<Integer> answers;

    public Answer() {
        this.answers = new ArrayList<>();
    }


    public void makeAnswers() {

        while (answers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answers.contains(randomNumber)) {
                answers.add(randomNumber);
            }
        }
    }

    public List<Integer> getAnswers() {
        return answers;
    }

    public void resetAnswers() {
        this.answers.clear();
    }
}
