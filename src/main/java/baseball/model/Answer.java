package baseball.model;

import static baseball.view.InputValidator.INPUT_LENGTH;

import baseball.vo.Score;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Answer {
    List<Integer> answer;
    Score score;

    public Answer(List<Integer> randomThreeNumber) {
        this.answer = randomThreeNumber;
    }

    public Score compare(List<Integer> userInput) {
        score = new Score();
        score.setStrike(calculateStrike(userInput));
        score.setBall(calculateBall(userInput));
        return score;
    }

    private int calculateBall(List<Integer> userInput) {
        return getContainNum(userInput) - score.getStrike();
    }

    private int calculateStrike(List<Integer> userInput) {
        int strike = 0;

        for (int i = 0; i < INPUT_LENGTH; i++) {
            if (userInput.get(i) == this.answer.get(i)) {
                strike++;
            }
        }
        return strike;
    }

    private int getContainNum(List<Integer> userInput) {
        int containNum = 0;

        for (int i = 0; i < INPUT_LENGTH; i++) {
            if (this.answer.contains(userInput.get(i))) {
                containNum++;
            }
        }
        return containNum;
    }

    public List<Integer> getAnswer() {
        return answer;
    }
}
