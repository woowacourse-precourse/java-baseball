package baseball.controller;

import baseball.model.Judge;
import baseball.model.Judgement;
import baseball.model.RandomGenerator;
import baseball.model.Validator;
import baseball.view.View;

import java.util.ArrayList;
import java.util.List;

public class Round {
    private final int STRIKE_TO_WIN = 3;
    private final Validator validator = new Validator();
    private final RandomGenerator randomGenerator = new RandomGenerator();

    public void play(View view) throws IllegalArgumentException {
        List<Integer> quizNumber = randomGenerator.randomGenerate();
        while (true) {
            List<Integer> userNumber = toIntegerList(view.requestGuess());
            validator.validate(userNumber);
            Judgement judgement = Judge.judge(quizNumber, userNumber);
            view.result(judgement.getBall(), judgement.getStrike());
            if (judgement.getStrike() == STRIKE_TO_WIN) {
                break;
            }
        }
        view.end();
        retry(view);
    }

    void retry(View view) throws IllegalArgumentException {
        boolean retry = view.askRetry();
        if (retry) {
            play(view);
        }
    }

    private List<Integer> toIntegerList(String input) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            result.add(input.charAt(i) - '0');
        }
        return result;
    }
}