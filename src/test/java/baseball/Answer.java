package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Answer {
    private List<Integer> answers;

    public Answer(List<Integer> answers) {
        this.answers = answers;
    }


    public List<Integer> makeAnswers() {

        while (this.answers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!this.answers.contains(randomNumber)) {
                this.answers.add(randomNumber);
            }
        }
        return this.answers;
    }
}
