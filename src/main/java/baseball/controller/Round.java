package baseball.controller;

import baseball.model.QuizNumber;
import baseball.model.UserNumber;
import baseball.view.View;

public class Round {
    public void play(View view) throws IllegalArgumentException {
        QuizNumber quizNumber = new QuizNumber();
        view.requestGuess();
        UserNumber userNumber = new UserNumber();
        userNumber.input();
    }
}