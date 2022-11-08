package baseball.controller;

import baseball.model.Judge;
import baseball.model.Judgement;
import baseball.model.QuizNumber;
import baseball.model.UserNumber;
import baseball.view.View;

public class Round {
    public void play(View view) throws IllegalArgumentException {
        QuizNumber quizNumber = new QuizNumber();
        while (true) {
            String input = view.requestGuess();
            UserNumber userNumber = new UserNumber();
            userNumber.validate(input);
            Judgement judgement = Judge.judge(quizNumber.getNumbers(), userNumber.getNumbers());
            view.result(judgement.getBall(), judgement.getStrike());
            if (judgement.getStrike() == 3) {
                break;
            }
        }
        view.end();
        retry(view);
    }
    void retry(View view) throws IllegalArgumentException {
        Boolean retry = view.askRetry();
        if (retry) {
            play(view);
        }
    }
}