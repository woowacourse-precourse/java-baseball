package baseball.controller;

import baseball.model.QuizNumber;
import baseball.view.View;

public class Round {
    public void play(View view) {
        QuizNumber quizNumber = new QuizNumber();
        view.requestGuess();
    }
}