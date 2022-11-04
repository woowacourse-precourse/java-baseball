package baseball;

import abstracts.Game;
import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class BaseballGame extends Game {
    private List<Integer> answerNumbers;

    BaseballGame() {
        this.gameName = "Baseball";
        this.status = Status.PLAYING;
        this.initialize();
    }

    private List<Integer> getAnswerNumbers() {
        return this.answerNumbers;
    }

    private void setAnswerNumbers(List<Integer> answerNumbers) {
        this.answerNumbers = answerNumbers;
    }

    private List<Integer> getRandomNumbersOf(int count) {
        List<Integer> answerNumbers = new ArrayList<>();
        while (answerNumbers.size() < count) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answerNumbers.contains(randomNumber)) {
                answerNumbers.add(randomNumber);
            }
        }
        return answerNumbers;
    }
    @Override
    protected void initialize() {
    }


    @Override
    protected void terminate() {
    }
}
