package baseball;

import java.util.List;

public class PlayBall {
    private PlayBallUI playBallUI;
    private Computer computer;
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
        computer = new Computer();
        computer.setComputerRandomNumber();
    }

    public void handleUserInput(){
        String userNumber = playBallUI.takeUserInput();
        exceptionHandler = new ExceptionHandler();
        //todo Referee

        exceptionHandler.checkIsDigit(userNumber);
        exceptionHandler.checkIsValidLength(userNumber);

    }
}
