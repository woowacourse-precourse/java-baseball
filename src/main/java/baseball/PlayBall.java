package baseball;

import java.util.ArrayList;
import java.util.List;

public class PlayBall {
    private PlayBallUI playBallUI;
    private Computer computer;
    private Referee referee;
    private ExceptionHandler exceptionHandler;

    public void startGame() {
        if (this.playBallUI == null){
            this.playBallUI = new PlayBallUI();
        }
        setComputerNumber();
        playBallUI.startInterface();
        handleUserInput();
    }

    public void setComputerNumber(){
        this.computer = new Computer();
        computer.setComputerRandomNumber();
    }

    public void handleUserInput(){
        boolean isGameOver = false;

        while(!isGameOver){
            String userNumberInput = playBallUI.takeUserNumberInput();
            checkUserInput(userNumberInput);

            this.referee = judgeUserNumber(userNumberInput);
            int strike = referee.getStrike();
            int ball = referee.getBall();
            playBallUI.showJudgeMessage(strike, ball);

            isGameOver = referee.isAnswer();
        }

        playBallUI.showAnswerMessage();
    }

    public void checkUserInput(String userNumberInput){
        exceptionHandler = new ExceptionHandler();

        exceptionHandler.checkIsDigit(userNumberInput);
        exceptionHandler.checkIsValidLength(userNumberInput);
    }

    public Referee judgeUserNumber(String userNumberInput){
        List<Integer> userNumber = new ArrayList<>();
        referee = new Referee(computer);

        for (int i = 0; i<3; i++){
            userNumber.add(userNumberInput.charAt(i) - '0');
        }

        return referee.Judge(userNumber);
    }
}
