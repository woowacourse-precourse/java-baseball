package baseball.controller;

import baseball.model.GameAnswer;
import baseball.model.MyAnswer;
import baseball.view.UserInterface;

import java.util.List;

public class GameSystem {
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final int ANSWER_LENGTH = 3;
    private static final int GAME_EXIT = 2;
    public static final UserInterface userInterface = new UserInterface();
    public GameAnswer gameAnswer;
    public MyAnswer myAnswer;
    private int strikeCount;
    private int ballCount;

    public GameSystem() {
        int gameLoop;
        gameAnswer = new GameAnswer();
        myAnswer = new MyAnswer();
        System.out.println(GAME_START_MESSAGE);

        while(true) {
            gameAnswer.setNumber();
            gameProcess();
            gameLoop = userInterface.checkGameRestart();
            if(gameLoop == GAME_EXIT) break;
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
                System.out.println(GAME_END_MESSAGE);
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

        for(int i = 0; i < ANSWER_LENGTH; i++) {
            computerDigit = computerDigitList.get(i);
            for(int j = 0; j < ANSWER_LENGTH; j++) {
                myDigit = myDigitList.get(j);
                strikeBallCount(computerDigit,i,myDigit,j);
            }
        }

        if(strikeCount == ANSWER_LENGTH) return true;
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
