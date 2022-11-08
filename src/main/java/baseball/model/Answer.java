package baseball.model;

import static baseball.controller.InputValidator.INPUT_LENGTH;

import baseball.vo.Score;
import java.util.List;

public class Answer {
    private static final int CORRECT_STRIKE_NUM = 3;
    List<Integer> answer;

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

    public Boolean isUserCorrect(Score userScore) {
        return userScore.getStrike() == CORRECT_STRIKE_NUM;
    }
}
