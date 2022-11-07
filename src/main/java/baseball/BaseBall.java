package baseball;

import baseball.answer.AnswerGenerator;
import baseball.input.UserInput;
import baseball.text.GameResultText;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class BaseBall {
    private final AnswerGenerator generator;
    private final UserInput userInput;

    private int ball;
    private int strike;
    private List<Integer> answer;
    private List<Integer> userAnswer;

    public BaseBall(AnswerGenerator generator, UserInput userInput) {
        this.generator = generator;
        this.userInput = userInput;
    }

    public void play() {
        init();
        while (strike != 3) {
            updateUserAnswer();
            updateResult();
            GameResultText.print(ball, strike);
        }
    }

    private void init() {
        this.answer = generator.generate();
        this.ball = 0;
        this.strike = 0;
    }

    private void updateUserAnswer() {
        String userStringAnswer = userInput.readAnswer();
        userAnswer = Arrays
                .stream(userStringAnswer.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void updateResult() {
        int tempBall = 0;
        int tempStrike = 0;

        for (int index = 0; index < 3; index++) {
            tempStrike += matchStrike(index);
            tempBall += matchBall(index);
        }

        ball = tempBall;
        strike = tempStrike;
    }

    private int matchStrike(int index) {
        if (answer.get(index).equals(userAnswer.get(index))) {
            return 1;
        }
        return 0;
    }

    private int matchBall(int index) {
        if (!answer.get(index).equals(userAnswer.get(index))
                && answer.contains(userAnswer.get(index))) {
            return 1;
        }
        return 0;
    }

}
