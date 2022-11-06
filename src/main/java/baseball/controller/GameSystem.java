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
        int gameLoop;
        gameAnswer = new GameAnswer();
        myAnswer = new MyAnswer();
        userInterface = new UserInterface();
        System.out.println("숫자 야구 게임을 시작합니다.");

        while(true) {
            gameAnswer.setNumber();
            gameProcess();
            gameLoop = userInterface.checkGameRestart();
            if(gameLoop == 2) break;
        }
    }

    public void gameProcess() {
        boolean correctAnswer;
        while(true) {
            initCount();
            setUserAnswer();
            correctAnswer = checkStrikeBall();
            userInterface.printResult(strikeCount,ballCount);
            if(correctAnswer) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
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
                strikeBallCount(computerDigit,i,myDigit,j);
            }
        }

        if(strikeCount == 3) return true;
        return false;
    }

    public void strikeBallCount(int computerDigit, int i, int myDigit, int j) {
        if(computerDigit == myDigit && i == j) strikeCount++;
        if(computerDigit == myDigit && i != j) ballCount++;
    }
    public void initCount() {
        strikeCount = 0;
        ballCount = 0;
    }

}
