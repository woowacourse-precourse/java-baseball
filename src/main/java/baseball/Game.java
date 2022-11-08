package baseball;

import computer.Computer;
import iosystem.InputSystem;
import user.User;

import java.util.List;

import static baseball.GameMessage.*;
import static baseball.GameMessage.START_GAME;

public class Game {

    private User user;
    private Computer computer;
    private Score score;

    public Game() {
        this.user = new User();
        this.computer = new Computer();
        this.score = new Score();
    }

    public void init() {
        this.user = new User();
        this.computer = new Computer();
        this.score = new Score();
    }
    public boolean isEndGame(){
        return score.getStrike() == 3;
    }

    public void start(){
        System.out.println(START_GAME.getMessage());
        boolean inputRetryNumber = true;
        boolean correctAnswer = false;
        while (inputRetryNumber){
            init();
            while (!correctAnswer){
                correctAnswer = play();
            }
            inputRetryNumber = checkRestart();
            correctAnswer = false;
        }
    }

    public boolean play(){
        List<Digit> inputDigitNumber = InputSystem.inputTryNumber();
        List<Integer> targetNumber = computer.getTargetNumber();
        Digits digitTragetList = new Digits(InputSystem.convertDigit(targetNumber));
        System.out.println("user"+inputDigitNumber);
        System.out.println("com"+digitTragetList.getDigitList());
        List<ScoreStatus> scoreResultList = digitTragetList.checkAllDigits(new Digits(inputDigitNumber));
        score.countTotalScore(scoreResultList);
        score.printScore();
        if (isEndGame()){
            System.out.println(END_GAME.getMessage());
            return true;
        }
        score.clear();
        return false;
    }

    public boolean checkRestart(){
        return InputSystem.inputRetryNumber();
    }


}
