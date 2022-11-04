package baseball.controller;

import baseball.model.GameAnswer;
import baseball.model.MyAnswer;
import baseball.view.UserInterface;

public class GameSystem {
    public UserInterface userInterface;
    public GameAnswer gameAnswer;
    public MyAnswer myAnswer;

    public GameSystem() {
        gameAnswer = new GameAnswer();
        System.out.println(gameAnswer.getNumber());

        userInterface = new UserInterface();

        setUserAnswer();
        System.out.println(myAnswer.getAnswer());
    }

    public void setUserAnswer() {
        int number;
        number = userInterface.inputNumber();
        myAnswer = new MyAnswer(number);
    }

}
