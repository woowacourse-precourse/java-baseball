package baseball.controller;

import baseball.model.GameAnswer;
import baseball.model.MyAnswer;
import baseball.view.UserInterface;

import java.util.ArrayList;
import java.util.List;

public class GameSystem {
    public UserInterface userInterface;
    public GameAnswer gameAnswer;
    public MyAnswer myAnswer;
    private int strikeCount;
    private int ballCount;

    public GameSystem() {
        gameAnswer = new GameAnswer();
        myAnswer = new MyAnswer();
        userInterface = new UserInterface();

        gameProcess();
    }
    public void gameProcess() {
        boolean correctAnswer;
        while(true) {
            initCount();
            setUserAnswer();
            correctAnswer = checkStrikeBall();
            if(correctAnswer) break;
        }
    }

    public void setUserAnswer() {
        int number;
        number = userInterface.inputNumber();
        myAnswer.setAnswer(number);
    }

    public boolean checkStrikeBall() {
        for(int i = 0; i < 3; i++) {

        }
    }

    public void initCount() {
        strikeCount = 0;
        ballCount = 0;
    }

}
