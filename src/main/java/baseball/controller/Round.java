package baseball.controller;

import baseball.model.Judge;
import baseball.model.QuizNumber;
import baseball.model.UserNumber;
import baseball.view.View;
import java.util.List;

public class Round {
    public void play(View view) throws IllegalArgumentException {
        QuizNumber quizNumber = new QuizNumber();
        while (true) {
            view.requestGuess();
            UserNumber userNumber = new UserNumber();
            userNumber.input();
            List<Integer> result = Judge.judge(quizNumber.getNumbers(), userNumber.getNumbers());
            int ball = result.get(0);
            int strike = result.get(1);
            view.result(ball, strike);
            if (strike == 3) {
                break;
            }
        }
        view.end();
    }
}