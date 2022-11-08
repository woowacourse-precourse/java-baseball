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

        exceptionHandler = new ExceptionHandler();
        setComputerNumber();
        playBallUI.startInterface();
        controlGame();
    }

    public void setComputerNumber(){
        this.computer = new Computer();
        computer.setComputerRandomNumber();
    }

    public void controlGame(){
        boolean isGameOver = false;

        while(!isGameOver){
            String userNumberInput = playBallUI.takeUserNumberInput();
            checkUserInput(userNumberInput);

            referee = judgeUserNumber(userNumberInput);
            int strike = referee.getStrike();
            int ball = referee.getBall();
            playBallUI.showJudgeMessage(strike, ball);

            isGameOver = referee.isAnswer();
        }

        playBallUI.showAnswerMessage();
        String restartOptionInput = playBallUI.takeRestartOptionInput();
        whetherToRestart(restartOptionInput);
    }

    public void checkUserInput(String userNumberInput){
        exceptionHandler.checkIsNoneZeroDigit(userNumberInput);
        exceptionHandler.checkIsValidLength(userNumberInput);
        exceptionHandler.checkIsUniqueNumbers(userNumberInput);
    }

    public Referee judgeUserNumber(String userNumberInput){
        List<Integer> userNumber = new ArrayList<>();
        referee = new Referee(computer);

        for (int i = 0; i<3; i++){
            userNumber.add(userNumberInput.charAt(i) - '0');
        }

        return referee.judge(userNumber);
    }

    public void whetherToRestart(String restartOptionInput) {
        exceptionHandler.checkIsValidRestartInput(restartOptionInput);

        if (restartOptionInput.equals("1")) {
            startGame();
        }
    }
}
