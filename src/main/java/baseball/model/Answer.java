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
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < INPUT_LENGTH; i++) {
            if (userInput.get(i) == this.answer.get(i)) {
                strike++;
            } else if (this.answer.contains(userInput.get(i))) {
                ball++;
            }
        }
        return new Score(strike, ball);
    }
}
