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
        System.out.println(gameAnswer.getNumber());

        gameProcess();
    }
    public void gameProcess() {
        boolean correctAnswer;
        while(true) {
            initCount();
            setUserAnswer();
            correctAnswer = checkStrikeBall();
            System.out.println(strikeCount+ " " + ballCount);
            if(correctAnswer) break;
        }
    }

    public void setUserAnswer() {
        int number;
        number = userInterface.inputNumber();
        myAnswer.setAnswer(number);
    }

    public boolean checkStrikeBall() {
        List<Integer> computerDigitList = gameAnswer.getNumber();
        List<Integer> myDigitList = myAnswer.getAnswer();
        Integer computerDigit;
        Integer myDigit;

        for(int i = 0; i < 3; i++) {
            computerDigit = computerDigitList.get(i);
            for(int j = 0; j < 3; j++) {
                myDigit = myDigitList.get(j);
                if(computerDigit == myDigit && i == j) strikeCount++;
                if(computerDigit == myDigit && i != j) ballCount++;
            }
        }

        if(strikeCount == 3) return true;
        return false;
    }

    public void initCount() {
        strikeCount = 0;
        ballCount = 0;
    }

}
